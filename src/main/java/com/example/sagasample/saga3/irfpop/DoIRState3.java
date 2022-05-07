package com.example.sagasample.saga3.irfpop;

import com.example.sagasample.saga3.SagaContext3;
import com.example.sagasample.saga3.SagaState3;
import com.example.sagasample.saga3.SimpleSagaState3;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class DoIRState3 extends SimpleSagaState3 {
    public DoIRState3(IRFPOPSagaContext3 context){
        super(context);
    }

    public void doAction(){
        log.debug(stateName+":doAction():"+((IRFPOPSagaContext3)context).getOrderid());

    }
    public SagaState3 getNextState(){
        return new DoFPState3((IRFPOPSagaContext3)context);
    }

}
