package com.example.sagasample.saga3.eventbus;

import com.example.sagasample.saga3.eventbus.event.*;

import java.util.HashSet;
import java.util.function.Function;

public class EventBusFactory {

    private static final EventBusFactory getInstance=new EventBusFactory();



    private EventBusFactory(){
        DoIREventHandler3 irEventHandler3=new DoIREventHandler3();
        Function<SagaEvent3, SagaEvent3> irHandlerFunction = irEventHandler3::onEvent;

        DoFPEventHandler3 fpEventHandler3=new DoFPEventHandler3();
        Function<SagaEvent3, SagaEvent3> fpHandlerFunction = fpEventHandler3::onEvent;

        DoOPEventHandler3 opEventHandler3=new DoOPEventHandler3();
        Function<SagaEvent3, SagaEvent3> opHandlerFunction = opEventHandler3::onEvent;

        SimpleEventBus3.getInstance().register(DoIRSuccessEvent3.class,irHandlerFunction);
        SimpleEventBus3.getInstance().register(DoFPSuccessEvent3.class,fpHandlerFunction);
        SimpleEventBus3.getInstance().register(DoOPSuccessEvent3.class,opHandlerFunction);

        SimpleEventBus3.getInstance().register(DoIRCompensationSuccessEvent3.class,irHandlerFunction);
        SimpleEventBus3.getInstance().register(DoFPCompensationSuccessEvent3.class,irHandlerFunction);
        SimpleEventBus3.getInstance().register(DoOPCompensationSuccessEvent3.class,irHandlerFunction);

        SimpleEventBus3.getInstance().register(DoIRFailEvent3.class,irHandlerFunction);
        SimpleEventBus3.getInstance().register(DoFPFailEvent3.class,fpHandlerFunction);
        SimpleEventBus3.getInstance().register(DoOPFailEvent3.class,opHandlerFunction);

    }

    
    public static EventBusFactory getInstance(){
        return getInstance;
    }

    public static EventBus3 getEventBus(){
        return SimpleEventBus3.getInstance();
    }
}
