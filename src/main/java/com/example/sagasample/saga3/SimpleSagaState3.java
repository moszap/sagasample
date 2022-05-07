package com.example.sagasample.saga3;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@ToString
@Slf4j
public class SimpleSagaState3 implements SagaState3 {
    protected SagaContext3 context;
    protected String stateName=this.getClass().getSimpleName();
    public SimpleSagaState3(SagaContext3 context){
        this.context=context;
    }

    public void beforeAction(){
        //log.debug(stateName+":beforeAction():");
    }
    public void doAction(){
        log.debug(stateName+":doAction():");
    }
    public void afterAction(){
        //log.debug(stateName+":afterAction():");
    }

    public SagaState3 getNextState(){
        return null;
    }
}
