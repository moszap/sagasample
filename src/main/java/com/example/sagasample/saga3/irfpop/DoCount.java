package com.example.sagasample.saga3.irfpop;

public class DoCount {
    int doSuccessCount=0;
    int doCompensationSuccessCount=0;

    public void addDoSuccessCount(){
        doSuccessCount++;
    }

    public void addDoCompensationSuccessCount(){
        doCompensationSuccessCount++;
    }
}
