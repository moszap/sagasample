package com.example.sagasample.saga2.event;

import com.example.sagasample.saga1.SagaException1;
import com.example.sagasample.saga2.AbstractSagaEvent2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OPSagaEvent2 extends AbstractSagaEvent2 {
    public OPSagaEvent2(){
        super();
    }
    public OPSagaEvent2(boolean exFlag){
        super(exFlag);
    }
    public OPSagaEvent2(boolean exFlag, boolean unFlag){
        super(exFlag,unFlag);
    }
    public void exec() {
        log.debug(this+":exec()");

        if(isExecSuccess==false){
            throw new SagaException1(this.toString()+"exec(); Error!");
        }

    }
}
