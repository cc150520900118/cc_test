package com.cc.util.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by admin on 2019/5/29.
 */
public class Player implements Runnable{

    private CountDownLatch begin;

    private CountDownLatch end;

    Player(CountDownLatch begin,CountDownLatch end){
        this.begin = begin;
        this.end = end;
    }

    public void run() {

        try {
            begin.await();
            System.out.println(Thread.currentThread().getName() + " arrived !");
            //3、end.countDown() 可以在多个线程中调用  计算调用次数是所有线程调用次数的总和
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}