package com.example.sagasample.saga2;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


@Slf4j
public class SagaManager2 {

    private static SagaManager2 instance;

    private SagaManager2(){}

    //static block initialization for exception handling
    static{
        try{
            instance = new SagaManager2();
        }catch(Exception e){
            throw new SagaException2("Exception occured in creating SagaManager2 instance");
        }
    }

    public static SagaManager2 getInstance(){
        return instance;
    }

    @SneakyThrows
    SagaDefinition2 getSagaDefinition(Class cc){
        return (SagaDefinition2) cc.getConstructor().newInstance();
    }

    public void startSaga(Class T,SagaEvent2 event){
        List<SagaStep2> stepList=getSagaDefinition(T).getStepList();

        for(int i=0;i<stepList.size();i++){

            SagaStep2 step=stepList.get(i);
            try {
                step.getEventHandler().onDoEvent(event);
                //publishEvent(step.getDoHandler(),step.getDoEvent());
                //undoCommandStack.push(cmd);
                //successExecCommandList.add(cmd);
            }
            catch(Exception ex){
                log.info(ex.toString());
                //undoCommandStack.push(cmd);
                //unExecCommands();
                break;
            }

        }
    }

}
