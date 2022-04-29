package com.example.sagasample.saga1;

import lombok.ToString;

@ToString
public class SagaException1 extends RuntimeException {
    String errMsg;

    Throwable innErr;

    public SagaException1(String errMsg){
        this.errMsg=errMsg;
    }

    public SagaException1(String errMsg, Throwable innErr){
        this.errMsg=errMsg;
        this.innErr=innErr;
    }

}
