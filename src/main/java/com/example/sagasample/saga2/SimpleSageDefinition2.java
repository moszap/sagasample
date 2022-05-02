package com.example.sagasample.saga2;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

@Data
public class SimpleSageDefinition2 implements SagaDefinition2 {
    List<SagaStep2> stepList=new ArrayList<SagaStep2>();
    //HashMap<SagaEvent2,SagaEventHandler2> eventMap=new HashMap<SagaEvent2, SagaEventHandler2>();

    public void addSagaStep(SagaStep2 step){
        stepList.add(step);
        //registerStep(step);
    }

//    void registerStep(SagaStep2 step){
//        eventMap.put(step.getDoEvent(),step.getDoHandler());
//        eventMap.put(step.getCompensationEvent(),step.getCompensationHandler());
//        eventMap.put(step.getCompensationFailEvent(),step.getCompensationFailHandler());
//    }
//
//    void registerStepEvent(SagaEvent2 event,SagaEventHandler2 handler){
//        eventMap.put(event,handler);
//    }
}
