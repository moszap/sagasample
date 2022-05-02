package com.example.sagasample.saga2.irfpop;

import com.example.sagasample.saga2.SagaEvent2;
import com.example.sagasample.saga2.SagaEventHandler2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FPEventHandler2 extends SimpleEventHandler {
    public SagaEvent2 onDoEvent(SagaEvent2 ee){
        IRFPOPEvent event=(IRFPOPEvent)ee;
        log.debug(this+":onEvent():"+event);
        return event;
//        if(isExecSuccess==false){
//            throw new SagaException2(this.toString()+"onEvent(); Error!");
//        }
    }

    
}
