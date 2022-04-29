package com.example.sagasample.saga1;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

@Slf4j
@Getter
public class SagaManager {
    int successCmdNum=0;
    int failCmdNum=0;
    int failSuccessCmdNum=0;

    ArrayList<SagaCommand> commandList=new ArrayList<SagaCommand>();
    ArrayList<SagaCommand> successExecCommandList=new ArrayList<SagaCommand>();
    ArrayList<SagaCommand> failSuccessCommandList=new ArrayList<SagaCommand>();

    Stack<SagaCommand> undoCommandStack=new Stack<SagaCommand>();

    public void addCommand(SagaCommand cmd) {
        commandList.add(cmd);
    }
    public void execCommands(){
        for(int i=0;i<commandList.size();i++){
            SagaCommand cmd=commandList.get(i);
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
                SagaCommand cmd = undoCommandStack.pop();
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
