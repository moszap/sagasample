package com.example.sagasample.saga3.irfpop;

import com.example.sagasample.saga3.eventbus.SagaEvent3;

public interface DoCount {
    public int getDoSuccessCount();

    public int getDoCompensationSuccessCount() ;

    public void resetAllCount();

    public void addEventCount(SagaEvent3 event);

}
