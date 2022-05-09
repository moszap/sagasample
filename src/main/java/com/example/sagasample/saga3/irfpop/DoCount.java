package com.example.sagasample.saga3.irfpop;

public interface DoCount {
    public int getDoSuccessCount();

    public int getDoCompensationSuccessCount() ;

    public void resetAllCount();

}
