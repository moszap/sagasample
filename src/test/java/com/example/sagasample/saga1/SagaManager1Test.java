package com.example.sagasample.saga1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SagaManager1Test {

    SagaManager1 manager=null;

    @BeforeEach
    public void setUp() {

    }

    public void initCmdManager(boolean irFlagE,boolean irFlagU,boolean fpFlagE,boolean fpFlagU,boolean opFlagE,boolean opFlagU){
        IRSagaCommand1 irCmd=new IRSagaCommand1(irFlagE,irFlagU);
        FPSagaCommand1 fpCmd=new FPSagaCommand1(fpFlagE,fpFlagU);
        OPSagaCommand1 opCmd=new OPSagaCommand1(opFlagE,opFlagU);

        manager=new SagaManager1();
        manager.addCommand(irCmd);
        manager.addCommand(fpCmd);
        manager.addCommand(opCmd);
    }

    @Test
    public void testExecSuccess() throws Exception {
        initCmdManager(true,true,true,true,true,true);
        manager.execCommands();
        assertEquals(3,manager.getSuccessCmdNum());
        assertEquals(0,manager.getFailCmdNum());
    }

    @Test
    public void testExecFail_1() throws Exception {
        initCmdManager(false,true,true,true,true,true);
        manager.execCommands();
        assertEquals(0,manager.getSuccessCmdNum());
        assertEquals(0,manager.getFailCmdNum());
    }

    @Test
    public void testExecFail_2() throws Exception {
        initCmdManager(true,true,false,true,true,true);
        manager.execCommands();
        assertEquals(1,manager.getSuccessCmdNum());
        assertEquals(1,manager.getFailCmdNum());
    }

    @Test
    public void testExecFail_3_FS() throws Exception {
        initCmdManager(true,true,true,true,false,true);
        manager.execCommands();
        assertEquals(2,manager.getSuccessCmdNum());
        assertEquals(2,manager.getFailCmdNum());
        assertEquals(2,manager.getFailSuccessCmdNum());
    }

    @Test
    public void testExecFail_3F_F() throws Exception {
        initCmdManager(true,true,true,false,false,true);
        manager.execCommands();
        assertEquals(2,manager.getSuccessCmdNum());
        assertEquals(2,manager.getFailCmdNum());
        assertEquals(0,manager.getFailSuccessCmdNum());
    }
}
