package com.example.sagasample.saga3;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleSagaContext3 implements SagaContext3 {

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

}
