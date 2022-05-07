package com.example.sagasample.saga3;

public interface SagaState3 {
    public void beforeAction();
    public void doAction();
    public void afterAction();
    public SagaState3 getNextState();
}
