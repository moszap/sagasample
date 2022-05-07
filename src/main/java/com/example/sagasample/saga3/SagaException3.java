package com.example.sagasample.saga3;

import lombok.ToString;

@ToString
public class SagaException3 extends RuntimeException {
    String errMsg;

    Throwable innErr;

    public SagaException3(String errMsg){
        this.errMsg=errMsg;
    }

    public SagaException3(String errMsg, Throwable innErr){
        this.errMsg=errMsg;
        this.innErr=innErr;
    }

}
