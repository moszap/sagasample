package com.example.sagasample.saga2.irfpop;

import com.example.sagasample.saga2.SagaEvent2;
import com.example.sagasample.saga2.SagaException2;
import com.example.sagasample.saga2.SimpleEventHandler2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FPEventHandler2 extends SimpleEventHandler2 {

    int onDoErrorOrderid=2;
    int onCompensationErrorOrderid=5;

    public SagaEvent2 onDoEvent(SagaEvent2 ee){
        IRFPOPEvent2 event=(IRFPOPEvent2)ee;
        log.debug(this+":onDoEvent():"+event);

        if(event.getOrderid()==onDoErrorOrderid || event.getOrderid()==onCompensationErrorOrderid ){
            throw new SagaException2(this.toString()+"onEvent(); Error!");
        }

        return event;
    }

    public SagaEvent2 onCompensationEvent(SagaEvent2 ee){
        IRFPOPEvent2 event=(IRFPOPEvent2)ee;
        log.debug(this+":onCompensationEvent():"+event);

        if(event.getOrderid()==onCompensationErrorOrderid ){
            throw new SagaException2(this.toString()+"onEvent(); Error!");
        }

        return event;
    }


    public SagaEvent2 onCompensationFailEvent(SagaEvent2 ee){
        IRFPOPEvent2 event=(IRFPOPEvent2)ee;
        log.debug(this+":onCompensationFailEvent():"+event);

        return event;
    }
    
}
