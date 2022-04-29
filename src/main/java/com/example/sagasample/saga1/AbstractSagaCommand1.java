package com.example.sagasample.saga1;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public abstract class AbstractSagaCommand1 implements SagaCommand1 {

    boolean isExecSuccess=true;
    boolean isUnExceSuccess=true;

    public AbstractSagaCommand1(){

    }

    public AbstractSagaCommand1(boolean flag){
        this.isExecSuccess=flag;
    }

    public AbstractSagaCommand1(boolean exFlag, boolean unFlag){
        this.isExecSuccess=exFlag;
        this.isUnExceSuccess=unFlag;
    }

    public abstract void exec() throws SagaException1;

    public void unExec(){
        log.debug(this+":unExec()");
    }
}
