package com.example.sagasample.saga2;

import com.example.sagasample.saga2.SagaEvent2;
import com.example.sagasample.saga2.SagaEventHandler2;

public class SimpleEventHandler2 implements SagaEventHandler2 {
    public SagaEvent2 onDoEvent(SagaEvent2 event){
        return event;
    }
    public SagaEvent2 onCompensationEvent(SagaEvent2 event){
        return event;
    }
    public SagaEvent2 onCompensationFailEvent(SagaEvent2 event){
        return event;
    }
}
