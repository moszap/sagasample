package com.example.sagasample.saga1;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class IRSagaCommand1 extends AbstractSagaCommand1 {
    public IRSagaCommand1(){
        super();
    }
    public IRSagaCommand1(boolean exFlag){
        super(exFlag);
    }
    public IRSagaCommand1(boolean exFlag, boolean unFlag){
        super(exFlag,unFlag);
    }
    public void exec() {
        log.debug(this+":exec()");

        if(isExecSuccess==false){
            throw new SagaException1(this.toString()+"exec(); Error!");
        }

    }

    public void unExec(){
        log.debug(this+":unExec()");
        if(isUnExceSuccess==false){
            throw new SagaException1(this.toString()+"unExec(); Error!");
        }

    }
}
