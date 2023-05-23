package com.study.Service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author yangz
 * @create 2021-11-13-11:08
 * 定时任务类
 */
@Service
public class ScheduledService {

    /**
     * 在一个指定的时间执行这个方法
     *  注意cron表达式的用法；
     *  秒   分   时   日   月   周几
     */
    @Scheduled(cron ="0/5 * * * * ?" )
    public void hello(){
        System.out.println("hello,执行了");
    }
}
