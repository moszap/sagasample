package com.example.sagasample.saga1;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public abstract class AbstractSagaCommand implements  SagaCommand {

    boolean isExecSuccess=true;
    boolean isUnExceSuccess=true;

    public AbstractSagaCommand(){

    }

    public AbstractSagaCommand(boolean flag){
        this.isExecSuccess=flag;
    }

    public AbstractSagaCommand(boolean exFlag,boolean unFlag){
        this.isExecSuccess=exFlag;
        this.isUnExceSuccess=unFlag;
    }

    public abstract void exec() throws SagaException;

    public void unExec(){
        log.debug(this+":unExec()");
    }
}
