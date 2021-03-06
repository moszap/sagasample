package com.example.sagasample.saga3;

import com.example.sagasample.saga3.eventbus.EventBusFactory;
import com.example.sagasample.saga3.eventbus.EventBusType;
import com.example.sagasample.saga3.eventbus.SagaEvent3;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Getter
@Setter
@ToString
@Slf4j
public class SimpleSagaState3 implements SagaState3 {
    protected SagaContext3 context;
    protected String stateName=this.getClass().getSimpleName();
    protected SagaState3 nextState;

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
        return nextState;
    }


    public void fireEvent(SagaEvent3 event){
        EventBusFactory.getEventBus(EventBusType.IRFPOP).onEvent(event);
    }
}
