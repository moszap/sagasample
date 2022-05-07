package com.example.sagasample.saga3.irfpop;

import java.util.HashMap;

public class RemoteServiceState {
    private static final RemoteServiceState instance = new RemoteServiceState();

    HashMap<String,Boolean> remoteServiceStateMapA=new HashMap<String, Boolean>();

    public static RemoteServiceState getInstance() {
        return instance;
    }

    private RemoteServiceState() {
        remoteServiceStateMapA.put("DoIRState3",true);
        remoteServiceStateMapA.put("DoFPState3",true);
        remoteServiceStateMapA.put("DoOPState3",true);
    }


    public boolean getRemoteServiceState(String name){
        return remoteServiceStateMapA.get(name);
    }
}
