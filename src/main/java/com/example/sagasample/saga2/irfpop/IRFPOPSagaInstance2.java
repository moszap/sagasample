package com.example.sagasample.saga2.irfpop;

import com.example.sagasample.saga2.SagaDefinition2;
import com.example.sagasample.saga2.SimpleSagaInstance2;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class IRFPOPSagaInstance2 extends SimpleSagaInstance2 {

    public IRFPOPSagaInstance2(IRFPOPEvent2 event){
        super(event);
    }

    public SagaDefinition2 getSagaDefinition() {
        return new IRFPOPSagaDefinition();
    }


}
