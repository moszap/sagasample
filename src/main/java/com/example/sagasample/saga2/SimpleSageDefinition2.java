package com.example.sagasample.saga2;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

@Data
public class SimpleSageDefinition2 implements SagaDefinition2 {
    List<SagaStep2> stepList=new ArrayList<SagaStep2>();

    public void addSagaStep(SagaStep2 step){
        stepList.add(step);
    }

}
