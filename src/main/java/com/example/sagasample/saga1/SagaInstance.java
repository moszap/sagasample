package com.example.sagasample.saga1;

import lombok.extern.slf4j.Slf4j;

import java.util.EmptyStackException;

/**
 * Copyright (C),2022,FirstBank
 * FileName: SagaInstance
 * Author: Han-Ru
 * Date: 2022/5/4 下午 02:21
 * Description:
 */
@Slf4j
public class SagaInstance {
    CountClass count ;
    public SagaInstance(CountClass count){
        this.count=count;
    }
    public void execCommands(){
        for(int i=0;i<count.commandList.size();i++){
            SagaCommand1 cmd=count.commandList.get(i);
            try {
                cmd.exec();
                count.undoCommandStack.push(cmd);
                count.successExecCommandList.add(cmd);
            }
            catch(Exception ex){
                log.info(ex.toString());
                //undoCommandStack.push(cmd);
                unExecCommands();
                break;
            }

        }
    }
    public void unExecCommands(){
        count.failCmdNum=count.undoCommandStack.size();
        while(true){
            try {
                SagaCommand1 cmd = count.undoCommandStack.pop();
                cmd.unExec();
                count.failSuccessCommandList.add(cmd);
            }
            catch(EmptyStackException emptyEx){
                break;
            }
            catch(Exception ex){
                log.info(ex.toString());
                NotifyService.getInstance().notify(this,ex);
                break;
            }
        }
    }

}
