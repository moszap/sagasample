package com.example.sagasample.saga2;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;


@Slf4j
public class SimpleSagaManager2 implements SagaManager2 {
    private HashMap<String,SagaInstance2> tokenInstanceMap=new HashMap<String,SagaInstance2>();


    private static SimpleSagaManager2 instance;

    private SimpleSagaManager2(){}

    //static block initialization for exception handling
    static{
        try{
            instance = new SimpleSagaManager2();
        }catch(Exception e){
            throw new SagaException2("Exception occured in creating SagaManager2 instance");
        }
    }

    public static SimpleSagaManager2 getInstance(){
        return instance;
    }

    public String startSagaInstance(SagaInstance2 sagaInstance){
        String token=SagaUtil2.generateUUID();
        sagaInstance.execute();
        tokenInstanceMap.put(token,sagaInstance);
        return token;
    }


}
