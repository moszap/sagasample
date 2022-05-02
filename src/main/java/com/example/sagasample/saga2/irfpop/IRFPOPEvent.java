package com.example.sagasample.saga2.irfpop;

import com.example.sagasample.saga2.SagaEvent2;
import lombok.Getter;
import lombok.ToString;

import javax.annotation.processing.Generated;

@Getter
@ToString
public class IRFPOPEvent implements SagaEvent2 {

    int orderid;

    public IRFPOPEvent(int orderid){
        this.orderid=orderid;
    }


}
