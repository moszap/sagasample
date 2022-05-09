package com.example.sagasample.saga3.eventbus;

import com.example.sagasample.saga3.eventbus.event.*;
import com.example.sagasample.saga3.irfpop.DoCount;
import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Function;

@Getter
public class SimpleEventBus3 implements EventBus3 {

    private HashSet<Class> eventClassSet=new HashSet<>();

    private SimpleEventBus3(){

    }

    private static SimpleEventBus3 instance=new SimpleEventBus3();

    public static SimpleEventBus3 getInstance(){
        return instance;
    }

    private HashMap<Class<? extends SagaEvent3>,Function<SagaEvent3,SagaEvent3>> eventMap=new HashMap<>();


    public void register(Class<? extends SagaEvent3> c,Function function){
        eventMap.put(c,function);
        eventClassSet.add(c);
    }

    public SagaEvent3 onEvent(SagaEvent3 event){


        Function<SagaEvent3,SagaEvent3> f=eventMap.get(event.getClass());
        SimpleDoCount.getInstance().addEventCount(event.getContext().getContextID(), event);
        return f.apply(event);

    }





}
