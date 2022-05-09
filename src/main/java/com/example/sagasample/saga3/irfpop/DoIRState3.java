package com.example.sagasample.saga3.irfpop;

import com.example.sagasample.saga3.SimpleSagaState3;
import com.example.sagasample.saga3.eventbus.EventBusFactory;
import com.example.sagasample.saga3.eventbus.SimpleEventBus3;
import com.example.sagasample.saga3.eventbus.SagaEvent3;
import com.example.sagasample.saga3.eventbus.event.DoIREventHandler3;
import com.example.sagasample.saga3.eventbus.event.DoIRSuccessEvent3;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.function.Function;

@Slf4j
@Getter
public class DoIRState3 extends SimpleSagaState3 {

    public DoIRState3(IRFPOPSagaContext3 context){
        super(context);
    }


    public void doAction(){
        log.debug(stateName+":doAction():"+((IRFPOPSagaContext3)context).getOrderid());

        if(((IRFPOPSagaContext3) context).getRemoteServiceState().getRemoteServiceState(stateName)==true){
            setNextState(new DoFPState3((IRFPOPSagaContext3)context));
            DoIRSuccessEvent3 irSuccessEvent=new DoIRSuccessEvent3(context);
            fireEvent(irSuccessEvent);

        }
        else {
            setNextState(new DoIRCompensationState3((IRFPOPSagaContext3)context));
        }

    }


}
