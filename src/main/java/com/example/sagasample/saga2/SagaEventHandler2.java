package com.example.sagasample.saga2;

public interface SagaEventHandler2 {
    public SagaEvent2 onDoEvent(SagaEvent2 event);
    public SagaEvent2 onCompensationEvent(SagaEvent2 event);
    public SagaEvent2 onCompensationFailEvent(SagaEvent2 event);
}
