package com.example.sagasample.saga2.irfpop;

import com.example.sagasample.saga2.SagaEvent2;
import com.example.sagasample.saga2.SagaEventHandler2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OPEventHandler2 extends SimpleEventHandler {
    public void onDoEvent(SagaEvent2 event){
        log.debug(this+":onEvent()");

//        if(isExecSuccess==false){
//            throw new SagaException2(this.toString()+"onEvent(); Error!");
//        }
    }

    
}
