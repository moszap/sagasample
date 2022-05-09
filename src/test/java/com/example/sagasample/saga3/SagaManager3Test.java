package com.example.sagasample.saga3;

import com.example.sagasample.saga2.irfpop.IRFPOPEvent2;
import com.example.sagasample.saga2.irfpop.IRFPOPSagaInstance2;
import com.example.sagasample.saga3.irfpop.IRFPOPSagaContext3;
import com.example.sagasample.saga3.irfpop.RemoteServiceState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SagaManager3Test {

    SagaManager3 manager = null;

    @BeforeEach
    public void setUp() {
        manager = SimpleSagaManager3.getInstance();
    }


    @Test
    public void testExecSuccess() {
        boolean[] stateArr=new boolean[]{true,true,true,true,true,true};
        RemoteServiceState remoteServiceState=new RemoteServiceState(stateArr);
        IRFPOPSagaContext3 context=new IRFPOPSagaContext3(System.currentTimeMillis(),remoteServiceState);
        context.execute();

        assertEquals(3,context.getDoSuccessCount());
        assertEquals(0,context.getDoCompensationSuccessCount());
    }

    @Test
    public void testExecFail_2() throws Exception {
        boolean[] stateArr=new boolean[]{true,false,true,true,true,true};
        RemoteServiceState remoteServiceState=new RemoteServiceState(stateArr);
        IRFPOPSagaContext3 context=new IRFPOPSagaContext3(System.currentTimeMillis(),remoteServiceState);
        context.execute();

        assertEquals(1,context.getDoSuccessCount());
        assertEquals(2,context.getDoCompensationSuccessCount());
    }

    @Test
    public void testExecFail_3() throws Exception {
        boolean[] stateArr=new boolean[]{true,true,false,true,true,true};
        RemoteServiceState remoteServiceState=new RemoteServiceState(stateArr);
        IRFPOPSagaContext3 context=new IRFPOPSagaContext3(System.currentTimeMillis(),remoteServiceState);
        context.execute();

        assertEquals(2,context.getDoSuccessCount());
        assertEquals(3,context.getDoCompensationSuccessCount());
    }

    @Test
    public void testExecFail_4() throws Exception {
        boolean[] stateArr=new boolean[]{true,true,false,false,true,true};
        RemoteServiceState remoteServiceState=new RemoteServiceState(stateArr);
        IRFPOPSagaContext3 context=new IRFPOPSagaContext3(System.currentTimeMillis(),remoteServiceState);
        context.execute();

        assertEquals(2,context.getDoSuccessCount());
        assertEquals(2,context.getDoCompensationSuccessCount());
    }


    @Test
    public void testExecFail_5() throws Exception {
        boolean[] stateArr=new boolean[]{true,true,false,true,false,true};
        RemoteServiceState remoteServiceState=new RemoteServiceState(stateArr);
        IRFPOPSagaContext3 context=new IRFPOPSagaContext3(System.currentTimeMillis(),remoteServiceState);
        context.execute();

        assertEquals(2,context.getDoSuccessCount());
        assertEquals(1,context.getDoCompensationSuccessCount());
    }


}
