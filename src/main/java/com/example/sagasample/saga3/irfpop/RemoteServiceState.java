package com.example.sagasample.saga3.irfpop;

import java.util.HashMap;

public class RemoteServiceState {

    HashMap<String,Boolean> remoteServiceStateMapA=new HashMap<String, Boolean>();


    public RemoteServiceState(boolean[] stateArr) {
        remoteServiceStateMapA.put("DoIRState3",stateArr[0]);
        remoteServiceStateMapA.put("DoFPState3",stateArr[1]);
        remoteServiceStateMapA.put("DoOPState3",stateArr[2]);
    }


    public boolean getRemoteServiceState(String name){
        return remoteServiceStateMapA.get(name);
    }
}
