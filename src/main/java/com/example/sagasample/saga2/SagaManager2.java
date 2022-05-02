package com.example.sagasample.saga2;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

@Slf4j
public class SagaManager2 {
    SimpleSageDefinition2 definiton;

    public SagaManager2(SimpleSageDefinition2 definiton){
        this.definiton=definiton;
    }

    SagaDefinition2 getSagaDefinition(Class T){
        return (SagaDefinition2) cc.newInstance();
    }

    public void startSaga(Class T){
        List<SagaStep2> stepList=getSagaDefinition(T).getStepList();

        for(int i=0;i<stepList.size();i++){

            SagaStep2 step=stepList.get(i);
            try {
                step.getEventHandler().onDoEvent();
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
//    public void publishEvent(SagaEventHandler2 handler,SagaEvent2 event){
//        //step.getDoHandler().onEvent(step.getDoEvent());
//        handler.onEvent(event);
//    }
//
//    public void exec(){
//        ArrayList<SagaStep2> stepList=definiton.getStepList();
//        for(int i=0;i<stepList.size();i++){
//
//            SagaStep2 step=stepList.get(i);
//            try {
//                publishEvent(step.getDoHandler(),step.getDoEvent());
//                //undoCommandStack.push(cmd);
//                //successExecCommandList.add(cmd);
//            }
//            catch(Exception ex){
//                log.info(ex.toString());
//                //undoCommandStack.push(cmd);
//                //unExecCommands();
//                break;
//            }
//
//        }
//    }
}
