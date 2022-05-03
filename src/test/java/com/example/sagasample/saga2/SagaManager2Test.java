package com.example.sagasample.saga2;

import com.example.sagasample.saga2.irfpop.IRFPOPEvent2;
import com.example.sagasample.saga2.irfpop.IRFPOPSagaInstance2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SagaManager2Test {

    SagaManager2 manager = null;

    @BeforeEach
    public void setUp() {
        manager = SimpleSagaManager2.getInstance();
    }

    public IRFPOPSagaInstance2 initInstance(int orderid){
        IRFPOPEvent2 event = new IRFPOPEvent2(orderid);
        IRFPOPSagaInstance2 sagaInstance=new IRFPOPSagaInstance2(event);
        return sagaInstance;
    }
    @Test
    public void testExecSuccess() {
        IRFPOPSagaInstance2 sagaInstance=initInstance(0);
        String token=manager.startSagaInstance(sagaInstance);
        assertEquals(3,sagaInstance.getSuccessStepNum());
        assertEquals(0,sagaInstance.getFailStepNum());
        assertEquals(0,sagaInstance.getFailSuccessStepNum());
    }

    @Test
    public void testExecFail_2() throws Exception {
        IRFPOPSagaInstance2 sagaInstance=initInstance(2);
        String token=manager.startSagaInstance(sagaInstance);

        assertEquals(1,sagaInstance.getSuccessStepNum());
        assertEquals(1,sagaInstance.getFailStepNum());
        assertEquals(1,sagaInstance.getFailSuccessStepNum());
    }


    @Test
    public void testExecFail_3() throws Exception {
        IRFPOPSagaInstance2 sagaInstance=initInstance(3);
        String token=manager.startSagaInstance(sagaInstance);

        assertEquals(2,sagaInstance.getSuccessStepNum());
        assertEquals(2,sagaInstance.getFailStepNum());
        assertEquals(2,sagaInstance.getFailSuccessStepNum());

    }

    @Test
    public void testExecFail_5() throws Exception {
        IRFPOPSagaInstance2 sagaInstance=initInstance(5);
        String token=manager.startSagaInstance(sagaInstance);

        assertEquals(1,sagaInstance.getSuccessStepNum());
        assertEquals(1,sagaInstance.getFailStepNum());
        assertEquals(1,sagaInstance.getFailSuccessStepNum());

    }

    @Test
    public void testExecFail_6() throws Exception {
        IRFPOPSagaInstance2 sagaInstance=initInstance(6);
        String token=manager.startSagaInstance(sagaInstance);

        assertEquals(2,sagaInstance.getSuccessStepNum());
        assertEquals(2,sagaInstance.getFailStepNum());
        assertEquals(2,sagaInstance.getFailSuccessStepNum());

    }

    @Test
    public void testExecFail_7() throws Exception {
        IRFPOPSagaInstance2 sagaInstance=initInstance(7);
        String token=manager.startSagaInstance(sagaInstance);

        assertEquals(3,sagaInstance.getSuccessStepNum());
        assertEquals(0,sagaInstance.getFailStepNum());
        assertEquals(0,sagaInstance.getFailSuccessStepNum());

    }

}
