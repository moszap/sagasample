package com.example.sagasample.saga3;

import com.example.sagasample.saga3.SagaContext3;
import com.example.sagasample.saga3.SagaState3;
import com.example.sagasample.saga3.SimpleSagaState3;

public class EndState3 extends SimpleSagaState3 {
    public EndState3(SagaContext3 context){
        super(context);
    }
    public SagaState3 getNextState(){
        return null;
    }
}
