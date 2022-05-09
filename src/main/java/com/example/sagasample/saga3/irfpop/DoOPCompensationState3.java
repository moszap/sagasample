package com.example.sagasample.saga3.irfpop;

import com.example.sagasample.saga3.SimpleSagaState3;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoOPCompensationState3 extends SimpleSagaState3 {
    public DoOPCompensationState3(IRFPOPSagaContext3 context){
        super(context);
    }
    public void doAction(){
        log.debug(stateName+":doAction():"+((IRFPOPSagaContext3)context).getOrderid());

        if(((IRFPOPSagaContext3) context).getRemoteServiceState().getRemoteServiceState(stateName)==true){
            setNextState(new DoFPCompensationState3((IRFPOPSagaContext3)context));
            ((IRFPOPSagaContext3) context).addDoCompensationSuccessCount();
        }
        else {
            setNextState(new IRFPOPExceptionEndState3(context));
        }

    }
}
