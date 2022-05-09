package com.example.sagasample.saga3;

import com.example.sagasample.saga3.eventbus.*;
import com.example.sagasample.saga3.eventbus.event.*;
import com.example.sagasample.saga3.irfpop.IRFPOPSagaContext3;
import com.example.sagasample.saga3.irfpop.RemoteServiceState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleEventBus3Test {

    IRFPOPSagaContext3 context;

    @BeforeEach
    public void setUp() {
        boolean[] stateArr=new boolean[]{true,true,true,true,true,true};
        RemoteServiceState remoteServiceState=new RemoteServiceState(stateArr);
        context=new IRFPOPSagaContext3(System.currentTimeMillis(),remoteServiceState);
    }

    @Test
    public void testOnEventIRFPOP_Success() {


        DoIRSuccessEvent3 irSuccessEvent=new DoIRSuccessEvent3(context);
        DoFPSuccessEvent3 fpSuccessEvent=new DoFPSuccessEvent3(context);
        DoOPSuccessEvent3 opSuccessEvent=new DoOPSuccessEvent3(context);

        EventBusFactory.getInstance().getEventBus().onEvent(irSuccessEvent);
        EventBusFactory.getInstance().getEventBus().onEvent(fpSuccessEvent);
        EventBusFactory.getInstance().getEventBus().onEvent(opSuccessEvent);

        //assertEquals(3,context.getDoSuccessCount());
        //assertEquals(0,context.getDoCompensationSuccessCount());
    }

    @Test
    public void testOnEventIRFPOP_CompensationSuccess() {

        DoIRCompensationSuccessEvent3 irCompensationSuccessEvent=new DoIRCompensationSuccessEvent3(context);
        DoFPCompensationSuccessEvent3 fpCompensationSuccessEvent=new DoFPCompensationSuccessEvent3(context);
        DoOPCompensationSuccessEvent3 opCompensationSuccessEvent=new DoOPCompensationSuccessEvent3(context);

        EventBusFactory.getInstance().getEventBus().onEvent(irCompensationSuccessEvent);
        EventBusFactory.getInstance().getEventBus().onEvent(fpCompensationSuccessEvent);
        EventBusFactory.getInstance().getEventBus().onEvent(opCompensationSuccessEvent);

        //assertEquals(3,context.getDoSuccessCount());
        //assertEquals(0,context.getDoCompensationSuccessCount());
    }

    @Test
    public void testOnEventIRFPOP_Fail() {

        DoIRFailEvent3 irFailEvent=new DoIRFailEvent3(context);
        DoFPFailEvent3 fpFailEvent=new DoFPFailEvent3(context);
        DoOPFailEvent3 opFailEvent=new DoOPFailEvent3(context);

        EventBusFactory.getInstance().getEventBus().onEvent(irFailEvent);
        EventBusFactory.getInstance().getEventBus().onEvent(fpFailEvent);
        EventBusFactory.getInstance().getEventBus().onEvent(opFailEvent);

        //assertEquals(3,context.getDoSuccessCount());
        //assertEquals(0,context.getDoCompensationSuccessCount());
    }

}
