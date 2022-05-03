package com.example.sagasample.saga2;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

@Slf4j
@Getter
@Setter
public abstract class SimpleSagaInstance2 implements SagaInstance2{

    int successStepNum=0;
    int failStepNum=0;
    int failSuccessStepNum=0;

    protected List<SagaStep2> successExecStepList=new ArrayList<SagaStep2>();
    protected Stack<SagaStep2> undoStepStack=new Stack<SagaStep2>();
    protected List<SagaStep2> failSuccessStepList=new ArrayList<SagaStep2>();

    String instanceId;
    SagaDefinition2 sagaDefintion;
    protected SagaEvent2 event;

    public SimpleSagaInstance2(SagaDefinition2 sagaDefintion,SagaEvent2 event){
        this.sagaDefintion=sagaDefintion;
        this.event=event;
        instanceId=SagaUtil2.generateUUID();
    }

    public void execute(){
        List<SagaStep2> stepList=getSagaDefinition().getStepList();

        for(int i=0;i<stepList.size();i++){

            SagaStep2 step=stepList.get(i);
            try {
                step.getEventHandler().onDoEvent(event);
                undoStepStack.push(step);
                successExecStepList.add(step);
            }
            catch(Exception ex){
                log.info(ex.toString());
                //undoStepStack.push(step);
                unExecSteps();
                break;
            }

        }
    }

    public void unExecSteps(){
        failStepNum=undoStepStack.size();
        while(true){
            try {
                SagaStep2 step = undoStepStack.pop();
                step.getEventHandler().onCompensationEvent(event);
                failSuccessStepList.add(step);
            }
            catch(EmptyStackException emptyEx){
                break;
            }
            catch(Exception ex){
                log.info(ex.toString());

                notify(ex);
                break;
            }
        }
    }

    public void notify(Exception ex){
        log.info(this+":notify():"+ex.toString());
    }

    public SagaDefinition2 getSagaDefinition(){
        return sagaDefintion;
    }

    public int getSuccessStepNum(){
        successStepNum=successExecStepList.size();
        return successStepNum;
    }

    public int getFailSuccessStepNum(){
        failSuccessStepNum=failSuccessStepList.size();
        return failSuccessStepNum;
    }
}
