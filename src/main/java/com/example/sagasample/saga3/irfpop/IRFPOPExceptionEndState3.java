package com.example.sagasample.saga3.irfpop;

import com.example.sagasample.saga3.EndState3;
import com.example.sagasample.saga3.SagaContext3;
import com.example.sagasample.saga3.SimpleSagaState3;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IRFPOPExceptionEndState3 extends SimpleSagaState3 implements EndState3 {
    public IRFPOPExceptionEndState3(SagaContext3 context){
        super(context);
    }
    public void doAction(){
        log.debug("//==============================");
        log.debug(stateName+":doAction():");
    }
}
