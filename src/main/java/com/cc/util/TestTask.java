package com.cc.util;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class TestTask {
//异步任务此处必须返回Future，可以是Future<String>，也可以是Future<Integer>，自己定义具体的返回内容

    @Async
    public Future<String> test1() throws Exception{
        Thread.sleep(1000);
        System.out.println("线程:"+Thread.currentThread().getName()+"---执行任务1，用时1秒");

        return new AsyncResult<>("test1");
    }

    @Async("taskExecutor")
    public Future<String> test2() throws Exception{
        Thread.sleep(1500);
        System.out.println("线程:"+Thread.currentThread().getName()+"---执行任务2，用时1.5秒");
        return new AsyncResult<>("test2");
    }
    //@Async("taskExecutor")
    public Future<String> test3() throws Exception{
        Thread.sleep(1500);
        System.out.println("线程:"+Thread.currentThread().getName()+"---执行任务3，用时1.5秒");
        return new AsyncResult<>("test2");
    }

}

