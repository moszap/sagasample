package com.example.sagasample.saga1;

import lombok.Data;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Copyright (C),2022,FirstBank
 * FileName: CountClass
 * Author: Han-Ru
 * Date: 2022/5/4 下午 01:56
 * Description: CountClass
 */
@Data
public class CountClass {
    //int successCmdNum=0;
    int failCmdNum=0;
    //int failSuccessCmdNum=0;

    ArrayList<SagaCommand1> commandList=new ArrayList<SagaCommand1>();
    ArrayList<SagaCommand1> successExecCommandList=new ArrayList<SagaCommand1>();
    ArrayList<SagaCommand1> failSuccessCommandList=new ArrayList<SagaCommand1>();
    Stack<SagaCommand1> undoCommandStack=new Stack<SagaCommand1>();

}
