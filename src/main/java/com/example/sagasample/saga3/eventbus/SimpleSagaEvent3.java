package com.example.sagasample.saga3.eventbus;

import com.example.sagasample.saga3.SagaContext3;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SimpleSagaEvent3 implements SagaEvent3 {
    SagaContext3 context;
    public SimpleSagaEvent3(SagaContext3 context){
        this.context=context;
    }

}
