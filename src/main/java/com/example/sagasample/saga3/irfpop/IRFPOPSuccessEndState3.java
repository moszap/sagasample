package com.example.sagasample.saga3.irfpop;

import com.example.sagasample.saga3.EndState3;
import com.example.sagasample.saga3.SagaContext3;
import com.example.sagasample.saga3.SimpleSagaState3;

public class IRFPOPSuccessEndState3 extends SimpleSagaState3 implements EndState3 {
    public IRFPOPSuccessEndState3(SagaContext3 context){
        super(context);
    }

}
