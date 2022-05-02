package com.example.sagasample.saga2.irfpop;

import com.example.sagasample.saga2.SimpleSageDefinition2;

public class IRFPOPSagaDefinition extends SimpleSageDefinition2 {

    public IRFPOPSagaDefinition(){
        this.addSagaStep(new IRSagaStep2());
        this.addSagaStep(new FPSagaStep2());
        this.addSagaStep(new OPSagaStep2());
    }
}
