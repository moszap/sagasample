package com.example.sagasample.saga1;

import lombok.ToString;

@ToString
public class SagaException extends RuntimeException {
    String errMsg;

    Throwable innErr;

    public SagaException(String errMsg){
        this.errMsg=errMsg;
    }

    public SagaException(String errMsg,Throwable innErr){
        this.errMsg=errMsg;
        this.innErr=innErr;
    }

}
