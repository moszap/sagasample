package com.example.sagasample.saga3.irfpop;

import com.example.sagasample.saga3.SimpleSagaState3;
import com.example.sagasample.saga3.eventbus.event.DoFPSuccessEvent3;
import com.example.sagasample.saga3.eventbus.event.DoOPSuccessEvent3;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class DoOPState3 extends SimpleSagaState3 {
    public DoOPState3(IRFPOPSagaContext3 context){
        super(context);
    }
    public void doAction(){
        log.debug(stateName+":doAction():"+((IRFPOPSagaContext3)context).getOrderid());

        if(((IRFPOPSagaContext3) context).getRemoteServiceState().getRemoteServiceState(stateName)==true){
            setNextState(new IRFPOPSuccessEndState3(context));
            ((IRFPOPSagaContext3) context).addDoSuccessCount();
            DoOPSuccessEvent3 opSuccessEvent=new DoOPSuccessEvent3(context);
            fireEvent(opSuccessEvent);
        }
        else {
            setNextState(new DoOPCompensationState3((IRFPOPSagaContext3)context));
        }

    }
}
