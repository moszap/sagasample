package com.example.sagasample.saga2.irfpop;

import com.example.sagasample.saga2.SagaDefinition2;
import com.example.sagasample.saga2.SimpleSagaInstance2;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@Slf4j
public class IRFPOPSagaInstance extends SimpleSagaInstance2 {

    public IRFPOPSagaInstance(IRFPOPEvent event){
        super(event);
    }

    public SagaDefinition2 getSagaDefinition() {
        return new IRFPOPSagaDefinition();
    }


}
