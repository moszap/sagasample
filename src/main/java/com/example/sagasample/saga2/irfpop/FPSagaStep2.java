package com.example.sagasample.saga2.irfpop;

import com.example.sagasample.saga2.SagaEventHandler2;
import com.example.sagasample.saga2.SimpleSagaStep2;

public class FPSagaStep2 extends SimpleSagaStep2 {
    public SagaEventHandler2 getEventHandler(){
        return new FPEventHandler2();
    }

}
