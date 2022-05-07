package com.example.sagasample.saga3.irfpop;

import com.example.sagasample.saga3.SagaContext3;
import com.example.sagasample.saga3.SimpleSagaState3;
import lombok.Getter;

@Getter
public class DoOPState3 extends SimpleSagaState3 {
    public DoOPState3(IRFPOPSagaContext3 context){
        super(context);
    }
}
