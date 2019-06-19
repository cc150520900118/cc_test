package com.cc.util.wathread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by admin on 2019/5/28.
 */
//抽象线程类
public abstract class MyThread<T> implements Runnable{

    private String wa;
    private CountDownLatch begin,end;

    public MyThread(String wa, CountDownLatch begin, CountDownLatch end){
        this.wa = wa;
        this.begin = begin;
        this.end = end;
    }
    public abstract void ywmethod(String wa);
    @Override
    public void run() { //里面批量是先全部跑完
        try {
            //执行程序
            ywmethod(wa);
            begin.await();//阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //计数器减一
            end.countDown();//释放
        }
    }
}
