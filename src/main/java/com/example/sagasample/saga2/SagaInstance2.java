package com.example.sagasample.saga2;

import java.util.List;
import java.util.Stack;

public interface SagaInstance2 {
    public String getInstanceId();
    public SagaDefinition2 getSagaDefinition();
    public void execute();

    public SagaEvent2 getEvent();
    public void setEvent(SagaEvent2 event);

    public List<SagaStep2> getSuccessExecStepList();
    public void setSuccessExecStepList(List<SagaStep2> successExecStepList);

    public Stack<SagaStep2> getUndoStepStack();
    public void setUndoStepStack(Stack<SagaStep2> undoStepStack);
}
