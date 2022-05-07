package com.example.sagasample.saga3.irfpop;

import com.example.sagasample.saga3.SimpleSagaState3;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoIRCompensationState3 extends SimpleSagaState3 {
    public DoIRCompensationState3(IRFPOPSagaContext3 context){
        super(context);
    }
    public void doAction(){
        log.debug(stateName+":doAction():"+((IRFPOPSagaContext3)context).getOrderid());

        if(((IRFPOPSagaContext3) context).getRemoteServiceState().getRemoteServiceState(stateName)==true){
            setNextState(new IRFPOPFailEndState3(context));
        }
        else {

        }

    }
}
