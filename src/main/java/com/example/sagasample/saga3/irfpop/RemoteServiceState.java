package com.example.sagasample.saga3.irfpop;

import java.util.HashMap;

public class RemoteServiceState {

    HashMap<String,Boolean> remoteServiceStateMapA=new HashMap<String, Boolean>();


    public RemoteServiceState(boolean[] stateArr) {
        remoteServiceStateMapA.put("DoIRState3",stateArr[0]);
        remoteServiceStateMapA.put("DoFPState3",stateArr[1]);
        remoteServiceStateMapA.put("DoOPState3",stateArr[2]);
        remoteServiceStateMapA.put("DoIRCompensationState3",stateArr[3]);
        remoteServiceStateMapA.put("DoFPCompensationState3",stateArr[4]);
        remoteServiceStateMapA.put("DoOPCompensationState3",stateArr[5]);



    }


    public boolean getRemoteServiceState(String name){
        return remoteServiceStateMapA.get(name);
    }
}
