package com.example.sagasample.saga3.eventbus;

import java.util.function.Function;

public interface EventBus3 {
    public void register(Class<? extends SagaEvent3> c, Function function);

    public SagaEvent3 onEvent(SagaEvent3 event);

}
