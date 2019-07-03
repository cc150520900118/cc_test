package com.cc.util.thread0620;

import java.util.concurrent.CountDownLatch;

/**
 * Created by admin on 2019/6/20.
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        int number = 3;
        CountDownLatch latch = new CountDownLatch(number);
        ThreadDemo thread1 = new ThreadDemo(1);
        ThreadDemo thread2 = new ThreadDemo(2);
        ThreadDemo thread3 = new ThreadDemo(3);
        ThreadDemo thread4 = new ThreadDemo(4);
       //join的调用者为当前线程，后面的线程必须等调用join的线程执行完后才能执行
        //-------------------------------------
        thread1.start();
        thread1.join();//线程1 执行完，再执行2
        System.out.println("----");
        thread2.start();
        thread2.join();//线程2  执行完，再main is end
        System.out.println("main1 is end!");
        //-------------------------------------
        thread3.start();
        thread4.start();
        thread3.join();
        thread4.join();
        System.out.println("main1 is end!");


        //-------------------------------------

    }
}
class ThreadDemo extends Thread{
    private int number;
    public ThreadDemo(int number){
        this.number = number;
    }
    public void run(){
        System.out.println("Thread"+number+" is running");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread"+number+"is end");
    }
}