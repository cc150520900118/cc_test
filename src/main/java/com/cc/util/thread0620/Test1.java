package com.cc.util.thread0620;

import java.util.concurrent.CountDownLatch;

/**
 * Created by admin on 2019/6/20.
 */
public class  Test1{
    public static void main(String[] args) throws InterruptedException {
        int number = 3;
        CountDownLatch latch =  new CountDownLatch(number);

        for(int i=0;i<3;i++){
            ThreadDemo1 demo = new ThreadDemo1(latch);
            demo.start();
            System.out.println(i);
        }
        latch.await();
        System.out.println("Check it Out");
    }
}

class ThreadDemo1 extends Thread{

    private CountDownLatch latch;

    public ThreadDemo1(CountDownLatch latch){
        this.latch = latch;
    }

    public void run(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
    }
}