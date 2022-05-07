package com.example.sagasample.saga3.irfpop;

import com.example.sagasample.saga3.SagaState3;
import com.example.sagasample.saga3.SimpleSagaContext3;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IRFPOPSagaContext3 extends SimpleSagaContext3 {
    long orderid;
    RemoteServiceState remoteServiceState;
    public IRFPOPSagaContext3(long orderid,RemoteServiceState remoteServiceState){
        super();
        this.orderid=orderid;
        this.remoteServiceState=remoteServiceState;
        setCurrentState(new IRFPOPInitState3(this));



    }
}
