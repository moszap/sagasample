package com.example.sagasample.saga2;

import lombok.Data;

@Data
public class SimpleSagaStep2 implements SagaStep2 {
    SagaEvent2 doEvent;
    SagaEventHandler2 doHandler;

    SagaEvent2 compEvent;
    SagaEventHandler2 compHandler;

    SagaEvent2 compensationEvent;
    SagaEventHandler2 compensationHandler;

    SagaEvent2 compensationFailEvent;
    SagaEventHandler2 compensationFailHandler;

    public void registerDo(SagaEvent2 event,SagaEventHandler2 handler){
        this.doEvent=event;
        this.doHandler=handler;
    }

    public void registerCompensation(SagaEvent2 event,SagaEventHandler2 handler) {
        this.doEvent=event;
        this.doHandler=handler;
    }

    public void registerCompensationFail(SagaEvent2 event,SagaEventHandler2 handler) {
        this.compensationFailEvent=event;
        this.compensationFailHandler=handler;
    }


}
