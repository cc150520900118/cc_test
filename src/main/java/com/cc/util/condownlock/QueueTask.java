package com.cc.util.condownlock;

import java.util.concurrent.CountDownLatch;

/**
 * 排队的任务
 * Created by
 */
public class QueueTask implements Runnable{

    private CountDownLatch countDownLatch;

    public QueueTask(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
 /*       try {
            Thread.sleep(5000);
            System.out.println("排队成功，可以开始交费");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(countDownLatch != null) {
                countDownLatch.countDown();
            }
        }*/
        System.out.println("排队成功，可以开始交费");
        if(countDownLatch != null) {
            countDownLatch.countDown();
        }

    }
}