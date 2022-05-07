package com.example.sagasample.saga3.irfpop;

import com.example.sagasample.saga3.SagaState3;
import com.example.sagasample.saga3.SimpleSagaContext3;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IRFPOPSagaContext3 extends SimpleSagaContext3 {
    long orderid;
    public IRFPOPSagaContext3(long orderid){
        super();
        this.orderid=orderid;
        setCurrentState(new IRFPOPInitState3(this));



    }
}
