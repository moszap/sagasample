package com.example.sagasample.saga3.eventbus;

import java.util.HashMap;
import java.util.function.Function;

public class SimpleEventBus3 implements EventBus3 {

    private SimpleEventBus3(){

    }

    private static SimpleEventBus3 instance=new SimpleEventBus3();

    public static SimpleEventBus3 getInstance(){
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
