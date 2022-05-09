package com.example.sagasample.saga3.eventbus.event;

import com.example.sagasample.saga3.eventbus.SagaEvent3;
import com.example.sagasample.saga3.eventbus.SimpleEventHandler3;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DoFPEventHandler3 extends SimpleEventHandler3 {

    public SagaEvent3 onEvent(SagaEvent3 event){
        log.debug(this+".onEvent():"+event);
        return event;
    }

}
