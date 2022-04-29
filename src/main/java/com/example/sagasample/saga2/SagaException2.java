package com.example.sagasample.saga2;

import lombok.ToString;

@ToString
public class SagaException2 extends RuntimeException {
    String errMsg;

    Throwable innErr;

    public SagaException2(String errMsg){
        this.errMsg=errMsg;
    }

    public SagaException2(String errMsg, Throwable innErr){
        this.errMsg=errMsg;
        this.innErr=innErr;
    }

}
