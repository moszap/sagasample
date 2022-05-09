package com.example.sagasample.saga3.eventbus;

import com.example.sagasample.saga3.eventbus.event.*;
import com.example.sagasample.saga3.irfpop.DoCount;

import java.util.HashMap;
import java.util.Iterator;


public class SimpleDoCount implements DoCount {

    private SimpleDoCount(){

    }

    private static SimpleDoCount instance=new SimpleDoCount();

    public static SimpleDoCount getInstance(){
        return instance;
    }

    private HashMap<String,Integer> eventCountMap=new HashMap<>();

    public void addEventCount(String contextid,SagaEvent3 event){
        if(eventCountMap.get(getCountKey(contextid,event.getClass()))==null){
            eventCountMap.put(getCountKey(contextid,event.getClass()),0);
        }

        int count=getEventCount(contextid,event.getClass());
        eventCountMap.put(getCountKey(contextid,event.getClass()),count+1);


    }
    public int getEventCount(String contextid,Class eventClass){
        if(eventCountMap.get(getCountKey(contextid,eventClass))==null){
            eventCountMap.put(getCountKey(contextid,eventClass),0);
        }
        return (int)eventCountMap.get(getCountKey(contextid,eventClass));
    }

    public int getDoSuccessCount(String contextid){
        return getEventCount(contextid,DoIRSuccessEvent3.class)+getEventCount(contextid,DoFPSuccessEvent3.class)+getEventCount(contextid,DoOPSuccessEvent3.class);
    }

    public int getDoCompensationSuccessCount(String contextid){
        return getEventCount(contextid,DoIRCompensationSuccessEvent3.class) + getEventCount(contextid,DoFPCompensationSuccessEvent3.class) + getEventCount(contextid,DoOPCompensationSuccessEvent3.class);
    }

    public void resetAllCount(String contextid){

        for (Class c : SimpleEventBus3.getInstance().getEventClassSet()) {
            resetCount(contextid,c);
        }
    }

    public String getCountKey(String contextid,Class eventClass){
        return contextid+"_"+eventClass.getSimpleName();
    }

    public void resetCount(String contextid,Class eventClass){
        eventCountMap.put(getCountKey(contextid,eventClass),0);

    }
}
