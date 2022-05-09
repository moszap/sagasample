package com.example.sagasample.saga3.eventbus;



public class SimpleEventHandler3 implements SagaEventHandler3 {
    public SagaEvent3 onEvent(SagaEvent3 event){
        return event;
    }
}
