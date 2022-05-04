package com.example.sagasample.saga1;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

@Slf4j
@Getter
public class SagaManager1 {
//    int successCmdNum=0;
//    int failCmdNum=0;
//    int failSuccessCmdNum=0;
    CountClass count = new CountClass();
    SagaInstance sagaInstance = new SagaInstance(count);
//    ArrayList<SagaCommand1> commandList=new ArrayList<SagaCommand1>();
//    ArrayList<SagaCommand1> successExecCommandList=new ArrayList<SagaCommand1>();
//    ArrayList<SagaCommand1> failSuccessCommandList=new ArrayList<SagaCommand1>();



    public void addCommand(SagaCommand1 cmd) {
        count.commandList.add(cmd);
    }
    public void execCommands(){
        sagaInstance.execCommands();
//        for(int i=0;i<count.commandList.size();i++){
//            SagaCommand1 cmd=count.commandList.get(i);
//            try {
//                cmd.exec();
//                count.undoCommandStack.push(cmd);
//                count.successExecCommandList.add(cmd);
//            }
//            catch(Exception ex){
//                log.info(ex.toString());
//                //undoCommandStack.push(cmd);
//                unExecCommands();
//                break;
//            }
//
//        }
    }
    public void unExecCommands(){
        sagaInstance.unExecCommands();
//        count.failCmdNum=count.undoCommandStack.size();
//        while(true){
//            try {
//                SagaCommand1 cmd = count.undoCommandStack.pop();
//                cmd.unExec();
//                count.failSuccessCommandList.add(cmd);
//            }
//            catch(EmptyStackException emptyEx){
//                break;
//            }
//            catch(Exception ex){
//                log.info(ex.toString());
//                NotifyService.getInstance().notify(this,ex);
//                break;
//            }
//        }
    }


    public int getSuccessCmdNum(){
//        count.setSuccessCmdNum(count.successExecCommandList.size());
        return count.successExecCommandList.size();
    }

    public int getFailSuccessCmdNum(){
//        count.setFailSuccessCmdNum(count.failSuccessCommandList.size());
        return count.failSuccessCommandList.size();
    }


    public int getFailCmdNum() {
        return count.failCmdNum;
    }
}
