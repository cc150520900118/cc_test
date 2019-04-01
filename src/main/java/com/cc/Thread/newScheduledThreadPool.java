package com.cc.Thread;

import java.util.concurrent.*;

/**
 * Created by changc on 2019/3/18.
 * 创建一个定长线程池，支持定时及周期性任务执行
 */
public class newScheduledThreadPool {
    private int ticket =10;

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);

         exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间就触发异常

            @Override

            public void run() {

                //throw new RuntimeException();

                System.out.println("================");

            }

        }, 1000, 5000, TimeUnit.MILLISECONDS);

        exec.scheduleAtFixedRate(new Runnable() {//每隔一段时间打印系统时间，证明两者是互不影响的

            @Override

            public void run() {

                System.out.println(System.nanoTime());

            }

        }, 1000, 2000, TimeUnit.MILLISECONDS);

    }
}
