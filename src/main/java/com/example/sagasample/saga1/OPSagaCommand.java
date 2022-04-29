package com.example.sagasample.saga1;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class OPSagaCommand extends AbstractSagaCommand {
    public OPSagaCommand(){
        super();
    }
    public OPSagaCommand(boolean exFlag){
        super(exFlag);
    }
    public OPSagaCommand(boolean exFlag,boolean unFlag){
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
