package com.example.sagasample.saga2;

import com.example.sagasample.saga1.SagaCommand1;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.UUID;


@Slf4j
public class SagaManager2 {
    private HashMap<String,SagaInstance2> instanceMap=new HashMap<String,SagaInstance2>();
    Stack<SagaCommand1> undoCommandStack=new Stack<SagaCommand1>();

    private static SagaManager2 instance;

    private SagaManager2(){}

    //static block initialization for exception handling
    static{
        try{
            instance = new SagaManager2();
        }catch(Exception e){
            throw new SagaException2("Exception occured in creating SagaManager2 instance");
        }
    }

    public static SagaManager2 getInstance(){
        return instance;
    }

    public String startSagaInstance(SagaInstance2 sagaInstance2){
        sagaInstance2.execute();
        String instanceToken=generateToken();
        instanceMap.put(instanceToken,sagaInstance2);
        return instanceToken;
    }

    public String generateToken(){
        UUID uuid4 = UUID.randomUUID();
        return uuid4.toString();
    }
}
