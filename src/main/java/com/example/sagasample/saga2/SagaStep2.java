package com.example.sagasample.saga2;


public interface SagaStep2 {

    public abstract void registerDo(SagaEvent2 event,SagaEventHandler2 handler);
    public abstract void registerCompensation(SagaEvent2 event,SagaEventHandler2 handler);

    public abstract SagaEvent2 getDoEvent();

    public SagaEventHandler2 getDoHandler();

    public SagaEvent2 getCompEvent();

    public SagaEventHandler2 getCompHandler();

    public SagaEvent2 getCompensationEvent();

    public SagaEventHandler2 getCompensationHandler();
    public SagaEvent2 getCompensationFailEvent();

    public SagaEventHandler2 getCompensationFailHandler() ;
}
