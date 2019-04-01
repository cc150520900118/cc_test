package com.cc.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by changc on 2019/3/18.
 * 创建一个单线程化的线程池，
 * 它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
 *
 * 创建一个单线程的线程池。这个线程池只有一个线程在工作，
 * 也就是相当于单线程串行执行所有任务。如果这个唯一的线程因为异常结束，
 * 那么会有一个新的线程来替代它。此线程池保证所有任务的执行顺序按照任务的提交顺序执行。
 *
 */
public class newSingleThreadExecutor implements Runnable {
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
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        newCachedThreadPool mt = new newCachedThreadPool();
        singleThreadExecutor.execute(mt);
        singleThreadExecutor.shutdown();
    }
}
