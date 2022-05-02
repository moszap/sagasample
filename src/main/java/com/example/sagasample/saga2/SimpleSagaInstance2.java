package com.example.sagasample.saga2;

import com.example.sagasample.saga1.SagaCommand1;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Getter
@Setter
public abstract class SimpleSagaInstance2 implements SagaInstance2{
    protected SagaEvent2 event;

    protected List<SagaStep2> successExecStepList=new ArrayList<SagaStep2>();
    protected Stack<SagaStep2> undoStepStack=new Stack<SagaStep2>();
    protected List<SagaStep2> failSuccessStepList=new ArrayList<SagaStep2>();

    public abstract SagaDefinition2 getSagaDefinition();
    public abstract void execute();
}
