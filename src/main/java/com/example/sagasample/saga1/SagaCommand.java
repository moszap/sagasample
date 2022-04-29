package com.example.sagasample.saga1;

public interface SagaCommand {
    public abstract void exec() throws SagaException;
    public abstract void unExec();
}
