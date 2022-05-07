package com.example.sagasample.saga3.irfpop;

import com.example.sagasample.saga3.SagaContext3;
import com.example.sagasample.saga3.SagaState3;
import com.example.sagasample.saga3.SimpleSagaState3;
import lombok.Getter;

@Getter
public class DoFPState3 extends SimpleSagaState3 {
    public DoFPState3(IRFPOPSagaContext3 context){
        super(context);
    }
    public SagaState3 getNextState() {
        return new DoOPState3((IRFPOPSagaContext3) context);
    }
}
