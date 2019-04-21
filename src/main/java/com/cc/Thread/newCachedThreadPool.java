package com.cc.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by changc on 2019/3/18.
 *
 *newCachedThreadPool创建一个可缓存线程池，
 * 如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 *
 * 创建一个可缓存的线程池。如果线程池的大小超过了处理任务所需要的线程，
 * 那么就会回收部分空闲（60秒不执行任务）的线程，当任务数增加时，
 * 此线程池又可以智能的添加新线程来处理任务。此线程池不会对线程池大小做限制，
 * 线程池大小完全依赖于操作系统（或者说JVM）能够创建的最大线程大小。
 */
public class newCachedThreadPool implements Runnable{
    private int ticket =500;
    @Override
    public void run() {
        for(int i =0;i<100;i++){
            if(this.ticket>0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"卖票---->"+(this.ticket--));
                System.out.println("[1111]当前线程" + Thread.currentThread().getName()+"----");
            }
        }
    }


    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        newCachedThreadPool mt = new newCachedThreadPool();
        cachedThreadPool.execute(mt);
        cachedThreadPool.shutdown();
    }

}
