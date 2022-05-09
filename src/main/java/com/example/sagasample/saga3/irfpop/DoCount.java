package com.example.sagasample.saga3.irfpop;

import com.example.sagasample.saga3.eventbus.SagaEvent3;



public interface DoCount {
    public int getDoSuccessCount(String contextid);

    public int getDoCompensationSuccessCount(String contextid) ;

    public void resetAllCount(String contextid);

    public void addEventCount(String contextid,SagaEvent3 event);

}
