package com.example.sagasample.saga1;

import com.example.sagasample.saga2.SagaManager2;
import com.example.sagasample.saga2.SimpleSageDefinition2;
import com.example.sagasample.saga2.irfpop.FPSagaEvent2;
import com.example.sagasample.saga2.irfpop.IRSagaEvent2;
import com.example.sagasample.saga2.irfpop.OPSagaEvent2;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SagaManager2Test {

    SagaManager2 manager=null;

    @BeforeEach
    public void setUp() {

    }

    public void initCmdManager(boolean irFlagE,boolean irFlagU,boolean fpFlagE,boolean fpFlagU,boolean opFlagE,boolean opFlagU){
        IRSagaEvent2 irEvent=new IRSagaEvent2(irFlagE,irFlagU);
        FPSagaEvent2 fpEvent=new FPSagaEvent2(fpFlagE,fpFlagU);
        OPSagaEvent2 opEvent=new OPSagaEvent2(opFlagE,opFlagU);

        SimpleSageDefinition2 definition=new SimpleSageDefinition2();

        manager=new SagaManager2();

    }

}
