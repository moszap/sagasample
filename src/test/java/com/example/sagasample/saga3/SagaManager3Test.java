package com.example.sagasample.saga3;

import com.example.sagasample.saga2.irfpop.IRFPOPEvent2;
import com.example.sagasample.saga2.irfpop.IRFPOPSagaInstance2;
import com.example.sagasample.saga3.irfpop.IRFPOPSagaContext3;
import com.example.sagasample.saga3.irfpop.RemoteServiceState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SagaManager3Test {

    SagaManager3 manager = null;

    @BeforeEach
    public void setUp() {
        manager = SimpleSagaManager3.getInstance();
    }


    @Test
    public void testExecSuccess() {
        boolean[] stateArray=new boolean[]{false,true,true};
        RemoteServiceState remoteServiceState=new RemoteServiceState(stateArray);
        remoteServiceState.getRemoteServiceState("DoIRState3");
        SagaContext3 context=new IRFPOPSagaContext3(System.currentTimeMillis(),remoteServiceState);
        context.execute();
    }


}
