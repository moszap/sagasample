package com.example.sagasample.saga2;

import com.example.sagasample.saga2.irfpop.SimpleEventHandler;
import lombok.Data;

@Data
public abstract class SimpleSagaStep2 implements SagaStep2 {

    public SagaEventHandler2 getEventHandler(){
        return new SimpleEventHandler();
    }


}
