package com.example.sagasample.saga2.irfpop;

import com.example.sagasample.saga2.SagaEventHandler2;
import com.example.sagasample.saga2.SimpleSagaStep2;

public class OPSagaStep2 extends SimpleSagaStep2 {
    public SagaEventHandler2 getEventHandler(){
        return new IREventHandler2();
    }

}
