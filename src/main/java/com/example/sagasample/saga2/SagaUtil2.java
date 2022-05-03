package com.example.sagasample.saga2;

import java.util.UUID;

public class SagaUtil2 {
    public static String generateUUID(){
        UUID uuid4 = UUID.randomUUID();
        return uuid4.toString();
    }
}
