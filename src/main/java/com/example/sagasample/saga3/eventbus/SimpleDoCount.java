package com.example.sagasample.saga3.eventbus;

import com.example.sagasample.saga3.eventbus.event.*;
import com.example.sagasample.saga3.irfpop.DoCount;

import java.util.HashMap;

public class SimpleDoCount implements DoCount {

    private SimpleDoCount(){

    }

    private static SimpleDoCount instance=new SimpleDoCount();

    public static SimpleDoCount getInstance(){
        return instance;
    }

    private HashMap<Class<? extends SagaEvent3>,Integer> eventCountMap=new HashMap<>();

    public void addEventCount(SagaEvent3 event){
        if(eventCountMap.get(event.getClass())==null){
            eventCountMap.put(event.getClass(),0);
        }

        int count=getEventCount(event.getClass());
        eventCountMap.put(event.getClass(),count+1);


    }
    public int getEventCount(Class eventClass){
        if(eventCountMap.get(eventClass)==null){
            eventCountMap.put(eventClass,0);
        }
        return (int)eventCountMap.get(eventClass);
    }

    public int getDoSuccessCount(){
        return getEventCount(DoIRSuccessEvent3.class)+getEventCount(DoFPSuccessEvent3.class)+getEventCount(DoOPSuccessEvent3.class);
    }

    public int getDoCompensationSuccessCount(){
        return getEventCount(DoIRCompensationSuccessEvent3.class) + getEventCount(DoFPCompensationSuccessEvent3.class) + getEventCount(DoOPCompensationSuccessEvent3.class);
    }

    public void resetAllCount(){
        resetCount(DoIRSuccessEvent3.class);
        resetCount(DoFPSuccessEvent3.class);
        resetCount(DoOPSuccessEvent3.class);
        resetCount(DoIRCompensationSuccessEvent3.class);
        resetCount(DoFPCompensationSuccessEvent3.class);
        resetCount(DoOPCompensationSuccessEvent3.class);

    }
    public void resetCount(Class eventClass){
        eventCountMap.put(eventClass,0);
    }
}
