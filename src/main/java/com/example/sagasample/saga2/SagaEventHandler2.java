package com.example.sagasample.saga2;

public interface SagaEventHandler2 {
    public void onDoEvent(SagaEvent2 event);
    public void onCompensationEvent(SagaEvent2 event);
    public void onCompensationFailEvent(SagaEvent2 event);
}
