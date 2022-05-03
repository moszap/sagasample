package com.example.sagasample.saga2.irfpop;

import com.example.sagasample.saga2.SagaEvent2;
import com.example.sagasample.saga2.SimpleSagaEvent2;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class IRFPOPEvent2 extends SimpleSagaEvent2 {

    int orderid;

    public IRFPOPEvent2(int orderid){
        this.orderid=orderid;
    }


}
