package com.example.sagasample.saga3.irfpop;

import com.example.sagasample.saga3.SimpleSagaState3;
import com.example.sagasample.saga3.eventbus.event.DoFPSuccessEvent3;
import com.example.sagasample.saga3.eventbus.event.DoIRSuccessEvent3;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class DoFPState3 extends SimpleSagaState3 {
    public DoFPState3(IRFPOPSagaContext3 context){
        super(context);
    }
    public void doAction(){
        log.debug(stateName+":doAction():"+((IRFPOPSagaContext3)context).getOrderid());

        if(((IRFPOPSagaContext3) context).getRemoteServiceState().getRemoteServiceState(stateName)==true){
            setNextState(new DoOPState3((IRFPOPSagaContext3)context));
            DoFPSuccessEvent3 fpSuccessEvent=new DoFPSuccessEvent3(context);
            fireEvent(fpSuccessEvent);
        }
        else {
            setNextState(new DoFPCompensationState3((IRFPOPSagaContext3)context));
        }

    }
}
