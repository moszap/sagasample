package com.example.sagasample.saga3;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class SimpleSagaContext3 implements SagaContext3 {

    protected String contextid= UUID.randomUUID().toString();
    //String contextName;

    protected SagaState3 currentState;
    public SimpleSagaContext3(){

    }
    public SimpleSagaContext3(SagaState3 state){
        this.currentState=state;
    }

    public void execute(){
        while(currentState!=null) {
            currentState.beforeAction();
            currentState.doAction();
            currentState.afterAction();
            currentState=currentState.getNextState();
        }
    }

    public String getContextID(){
        return contextid;
    }


}
