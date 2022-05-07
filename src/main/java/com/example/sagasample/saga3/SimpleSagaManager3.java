package com.example.sagasample.saga3;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class SimpleSagaManager3 implements SagaManager3 {



    private static SimpleSagaManager3 instance;

    private SimpleSagaManager3(){}

    //static block initialization for exception handling
    static{
        try{
            instance = new SimpleSagaManager3();
        }catch(Exception e){
            throw new SagaException3("Exception occured in creating SimpleSagaManager3 instance");
        }
    }

    public static SimpleSagaManager3 getInstance(){
        return instance;
    }




}
