package com.example.sagasample.saga1;

public interface SagaCommand1 {
    public abstract void exec() throws SagaException1;
    public abstract void unExec();
}
