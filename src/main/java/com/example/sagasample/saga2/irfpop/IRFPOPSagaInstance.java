package com.example.sagasample.saga2.irfpop;

import com.example.sagasample.saga1.SagaCommand1;
import com.example.sagasample.saga2.*;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.EmptyStackException;
import java.util.List;

@Getter
@Setter
@Slf4j
public class IRFPOPSagaInstance extends SimpleSagaInstance2 {

    int successCmdNum=0;
    int failCmdNum=0;
    int failSuccessCmdNum=0;


    public IRFPOPSagaInstance(SagaEvent2 event){
        this.event=event;
    }

    public SagaDefinition2 getSagaDefinition() {
        return new IRFPOPSagaDefinition();
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
                undoStepStack.push(step);
                unExecSteps();
                break;
            }

        }
    }

    public void unExecSteps(){
        failCmdNum=undoStepStack.size();
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
}
