package com.example.sagasample.saga3;

import java.util.UUID;

public interface SagaContext3 {
    public String getContextID();
    public void execute();
    //public String getName();
}
