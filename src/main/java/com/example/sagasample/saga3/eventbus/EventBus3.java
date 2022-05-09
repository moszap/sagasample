package com.example.sagasample.saga3.eventbus;

import com.example.sagasample.saga3.eventbus.event.*;

import java.util.HashMap;
import java.util.function.Function;

public class EventBus3 {

    private EventBus3(){
        DoIREventHandler3 irEventHandler3=new DoIREventHandler3();
        Function<SagaEvent3, SagaEvent3> irHandlerFunction = irEventHandler3::onEvent;

        DoFPEventHandler3 fpEventHandler3=new DoFPEventHandler3();
        Function<SagaEvent3, SagaEvent3> fpHandlerFunction = fpEventHandler3::onEvent;

        DoOPEventHandler3 opEventHandler3=new DoOPEventHandler3();
        Function<SagaEvent3, SagaEvent3> opHandlerFunction = opEventHandler3::onEvent;

        register(DoIRSuccessEvent3.class,irHandlerFunction);
        register(DoFPSuccessEvent3.class,fpHandlerFunction);
        register(DoOPSuccessEvent3.class,opHandlerFunction);

        register(DoIRFailEvent3.class,irHandlerFunction);
        register(DoFPFailEvent3.class,fpHandlerFunction);
        register(DoOPFailEvent3.class,opHandlerFunction);
    }

    private static EventBus3 instance=new EventBus3();

    public static EventBus3 getInstance(){
        return instance;
    }

    private HashMap<Class<? extends SagaEvent3>,Function<SagaEvent3,SagaEvent3>> eventMap=new HashMap<>();

    public void register(Class<? extends SagaEvent3> c,Function function){
        eventMap.put(c,function);
    }

    public SagaEvent3 onEvent(SagaEvent3 event){
        Function<SagaEvent3,SagaEvent3> f=eventMap.get(event.getClass());
        return f.apply(event);

    }
}
