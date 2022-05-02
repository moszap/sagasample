package com.example.sagasample.saga2;

import com.example.sagasample.saga2.irfpop.SimpleEventHandler;
import lombok.Data;

@Data
public abstract class SimpleSagaStep2 implements SagaStep2 {

    //SagaEvent2 doEvent;
    //SagaEventHandler2 doHandler;

    //SagaEvent2 compensationEvent;
    //SagaEventHandler2 compensationHandler;

    //SagaEvent2 compensationFailEvent;
    //SagaEventHandler2 compensationFailHandler;

    //public abstract SagaEvent2 getDoEvent();
    public SagaEventHandler2 getEventHandler(){
        return new SimpleEventHandler();
    }


}
