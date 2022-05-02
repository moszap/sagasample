package com.example.sagasample.saga2;

import com.example.sagasample.saga2.irfpop.IRFPOPEvent;
import com.example.sagasample.saga2.irfpop.IRFPOPSagaDefinition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SagaManager2Test {

    SagaManager2 manager = null;

    @BeforeEach
    public void setUp() {
        manager = SagaManager2.getInstance();
    }

    @Test
    public void testExecSuccess() {
        IRFPOPEvent event = new IRFPOPEvent(1);
        manager.startSaga(IRFPOPSagaDefinition.class, event);
    }

}
