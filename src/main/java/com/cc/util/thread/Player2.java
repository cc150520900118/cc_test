package com.cc.util.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by admin on 2019/5/29.
 */
 public class Player2 implements Runnable{

    private CountDownLatch begin;

    private CountDownLatch end;

    Player2(CountDownLatch begin,CountDownLatch end){
        this.begin = begin;
        this.end = end;
    }

    public void run() {

        try {
            begin.await();
            System.out.println(Thread.currentThread().getName() + " arrived !");
               end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
