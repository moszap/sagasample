package com.example.sagasample.saga2.event;

import com.example.sagasample.saga1.SagaException1;
import com.example.sagasample.saga2.SagaEvent2;
import com.example.sagasample.saga2.SagaEventHandler2;

public class IREventHandler2 extends SagaEventHandler2 {
    public void onEvent(SagaEvent2 event){
        log.debug(this+":onEvent()");

        if(isExecSuccess==false){
            throw new SagaException2(this.toString()+"onEvent(); Error!");
        }
    }

    
}
