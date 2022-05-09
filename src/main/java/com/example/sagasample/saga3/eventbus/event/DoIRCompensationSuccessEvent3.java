package com.example.sagasample.saga3.eventbus.event;

import com.example.sagasample.saga3.SagaContext3;
import com.example.sagasample.saga3.eventbus.SimpleSagaEvent3;

public class DoIRCompensationSuccessEvent3 extends SimpleSagaEvent3 {
    public DoIRCompensationSuccessEvent3(SagaContext3 context){
        super(context);
    }
}
