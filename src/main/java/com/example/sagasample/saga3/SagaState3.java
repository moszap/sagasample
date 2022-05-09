package com.example.sagasample.saga3;

import com.example.sagasample.saga3.eventbus.SagaEvent3;

public interface SagaState3 {
    public void beforeAction();
    public void doAction();
    public void afterAction();
    public SagaState3 getNextState();

    public void fireEvent(SagaEvent3 event);
}
