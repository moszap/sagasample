package com.example.sagasample.saga3;

import com.example.sagasample.saga3.eventbus.*;
import com.example.sagasample.saga3.eventbus.event.*;
import com.example.sagasample.saga3.irfpop.IRFPOPSagaContext3;
import com.example.sagasample.saga3.irfpop.RemoteServiceState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventBus3Test {

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

        EventBus3.getInstance().onEvent(irSuccessEvent);
        EventBus3.getInstance().onEvent(fpSuccessEvent);
        EventBus3.getInstance().onEvent(opSuccessEvent);

        //assertEquals(3,context.getDoSuccessCount());
        //assertEquals(0,context.getDoCompensationSuccessCount());
    }

    @Test
    public void testOnEventIRFPOP_Fail() {

        DoIRFailEvent3 irFailEvent=new DoIRFailEvent3(context);
        DoFPFailEvent3 fpFailEvent=new DoFPFailEvent3(context);
        DoOPFailEvent3 opFailEvent=new DoOPFailEvent3(context);

        EventBus3.getInstance().onEvent(irFailEvent);
        EventBus3.getInstance().onEvent(fpFailEvent);
        EventBus3.getInstance().onEvent(opFailEvent);

        //assertEquals(3,context.getDoSuccessCount());
        //assertEquals(0,context.getDoCompensationSuccessCount());
    }

}
