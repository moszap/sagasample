package com.example.sagasample.saga2;


import java.util.List;

public interface SagaDefinition2 {
    public void addSagaStep(SagaStep2 step);
    public List<SagaStep2>  getStepList();
}
