package com.example.sagasample.saga2;

import lombok.AllArgsConstructor;
import lombok.Data;


public class AbstractSagaEvent2 implements SagaEvent2 {
    protected boolean isExecSuccess=true;
    protected boolean isUnExceSuccess=true;

    public AbstractSagaEvent2(){

    }

    public AbstractSagaEvent2(boolean flag){
        this.isExecSuccess=flag;
    }

    public AbstractSagaEvent2(boolean exFlag, boolean unFlag){
        this.isExecSuccess=exFlag;
        this.isUnExceSuccess=unFlag;
    }
}
