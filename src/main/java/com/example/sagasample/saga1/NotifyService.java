package com.example.sagasample.saga1;

import lombok.extern.slf4j.Slf4j;

/**
 * Copyright (C),2022,FirstBank
 * FileName: NotifyService
 * Author: Han-Ru
 * Date: 2022/5/4 下午 01:42
 * Description: notifyService
 */
@Slf4j
public class NotifyService {

    private NotifyService(){

    }

    private static final NotifyService instance=new NotifyService();

    public static NotifyService getInstance(){
        return instance;
    }

    public void notify(SagaInstance orig,Exception ex){
        log.info(orig+":notify():"+ex.toString());
    }

}
