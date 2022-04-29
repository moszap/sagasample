package com.example.sagasample.saga1;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

@Slf4j
@Getter
public class SagaManager1 {
    int successCmdNum=0;
    int failCmdNum=0;
    int failSuccessCmdNum=0;

    ArrayList<SagaCommand1> commandList=new ArrayList<SagaCommand1>();
    ArrayList<SagaCommand1> successExecCommandList=new ArrayList<SagaCommand1>();
    ArrayList<SagaCommand1> failSuccessCommandList=new ArrayList<SagaCommand1>();

    Stack<SagaCommand1> undoCommandStack=new Stack<SagaCommand1>();

    public void addCommand(SagaCommand1 cmd) {
        commandList.add(cmd);
    }
    public void execCommands(){
        for(int i=0;i<commandList.size();i++){
            SagaCommand1 cmd=commandList.get(i);
            try {
                cmd.exec();
                undoCommandStack.push(cmd);
                successExecCommandList.add(cmd);
            }
            catch(Exception ex){
                log.info(ex.toString());
                undoCommandStack.push(cmd);
                unExecCommands();
                break;
            }

        }
    }
    public void unExecCommands(){
        failCmdNum=undoCommandStack.size();
        while(true){
            try {
                SagaCommand1 cmd = undoCommandStack.pop();
                cmd.unExec();
                failSuccessCommandList.add(cmd);
            }
            catch(EmptyStackException emptyEx){
                break;
            }
            catch(Exception ex){
                log.info(ex.toString());

                notify(ex);
                break;
            }
        }
    }

    public void notify(Exception ex){
        log.info(this+":notify():"+ex.toString());
    }

    public int getSuccessCmdNum(){
        successCmdNum=successExecCommandList.size();
        return successCmdNum;
    }

    public int getFailSuccessCmdNum(){
        failSuccessCmdNum=failSuccessCommandList.size();
        return failSuccessCmdNum;
    }
}
