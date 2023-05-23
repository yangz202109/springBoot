package com.study.Service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author yangz
 * @create 2021-11-13-8:49
 * 一个线程类
 */
@Service
public class AsyncService{

    @Async
    public  void hello(){
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("数据处理中！！！");
    }
}
