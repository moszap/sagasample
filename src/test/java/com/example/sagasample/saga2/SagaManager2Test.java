package com.example.sagasample.saga2;

import com.example.sagasample.saga2.irfpop.IRFPOPEvent;
import com.example.sagasample.saga2.irfpop.IRFPOPSagaDefinition;
import com.example.sagasample.saga2.irfpop.IRFPOPSagaInstance;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SagaManager2Test {

    SagaManager2 manager = null;

    @BeforeEach
    public void setUp() {
        manager = SagaManager2.getInstance();
    }

    @Test
    public void testExecSuccess() {
        IRFPOPEvent event = new IRFPOPEvent(0);
        IRFPOPSagaInstance sagaInstance=new IRFPOPSagaInstance(event);
        manager.startSaga(sagaInstance);
    }

    @Test
    public void testExecFail_2() throws Exception {
        IRFPOPEvent event = new IRFPOPEvent(2);
        IRFPOPSagaInstance sagaInstance=new IRFPOPSagaInstance(event);

        //assertEquals(1,manager.getSuccessCmdNum());
        //assertEquals(2,manager.getFailCmdNum());
    }

}
