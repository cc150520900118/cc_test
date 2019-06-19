package com.cc.util.multipleThread.latchThread;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * Created by admin on 2019/5/28.
 */
//抽象线程类
public abstract class MyThread<T> implements Runnable{

    private List<T> list;
    private CountDownLatch begin,end;

    public MyThread(List<T> list, CountDownLatch begin, CountDownLatch end){
        this.list = list;
        this.begin = begin;
        this.end = end;
    }
    public abstract void ywmethod(List<T> list);
    @Override
    public void run() { //里面批量是先全部跑完
        try {
            //执行程序
            ywmethod(list);
            begin.await();//阻塞
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //计数器减一
            end.countDown();//释放
        }
    }
}
