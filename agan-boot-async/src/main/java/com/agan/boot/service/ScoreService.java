package com.agan.boot.service;


import jdk.nashorn.internal.runtime.logging.DebugLogger;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ScoreService {

    @Async
    public void addScore(){
        //TODO 模拟睡5秒，用于赠送积分处理
        try {
            Thread.sleep(1000*5);

            log.info("-----处理积分-----");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Async("scorePoolTaskExecutor")
    public void addScore2(){
        //TODO 模拟睡5秒，用于赠送积分处理
        try {
            Thread.sleep(1000*5);

            log.info("-----处理积分-----");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


}
