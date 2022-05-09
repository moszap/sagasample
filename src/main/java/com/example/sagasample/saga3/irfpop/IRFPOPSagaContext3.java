package com.example.sagasample.saga3.irfpop;

import com.example.sagasample.saga3.SimpleSagaContext3;
import com.example.sagasample.saga3.eventbus.EventBusFactory;
import com.example.sagasample.saga3.eventbus.SimpleDoCount;
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

    public void resetCount(){
        SimpleDoCount.getInstance().resetAllCount(contextid);
    }


    public int getDoSuccessCount(){
        return  SimpleDoCount.getInstance().getDoSuccessCount(contextid);
    }

    public int getDoCompensationSuccessCount(){
        return  SimpleDoCount.getInstance().getDoCompensationSuccessCount(contextid);
    }
}
