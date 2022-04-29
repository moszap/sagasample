package com.example.sagasample.saga1;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class FPSagaCommand extends AbstractSagaCommand {
    public FPSagaCommand(){
        super();
    }
    public FPSagaCommand(boolean exFlag){
        super(exFlag);
    }
    public FPSagaCommand(boolean exFlag,boolean unFlag){
        super(exFlag,unFlag);
    }
    public void exec() {
        log.debug(this+":exec()");

        if(isExecSuccess==false){
            throw new SagaException(this.toString()+"exec(); Error!");
        }

    }

    public void unExec(){
        log.debug(this+":unExec()");
        if(isUnExceSuccess==false){
            throw new SagaException(this.toString()+"unExec(); Error!");
        }

    }
}
