package com.cc.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by changc on 2019/3/18.
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
 * 创建固定大小的线程池。每次提交一个任务就创建一个线程，
 * 直到线程达到线程池的最大大小。线程池的大小一旦达到最大值就会保持不变，
 * 如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
 */
public class newFixedThreadPool implements Runnable {
    private int ticket =10;
    @Override
    public void run() {
        for(int i =0;i<500;i++){
            if(this.ticket>0){
                System.out.println(Thread.currentThread().getName()+"卖票---->"+(this.ticket--));
            }
        }
    }
    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        newCachedThreadPool mt = new newCachedThreadPool();
        fixedThreadPool.execute(mt);
        fixedThreadPool.shutdown();
    }
}
