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
           // ywmethod(list);
            int t=0;
           // while (t< list.size()){
                for (int i = 0; i < list.size(); i++) {//未保证这个数据全部执行完 1、加休眠  2、再加锁
                    System.out.println(Thread.currentThread().getName()+"------"+list.get(i)+" ");
                    t++;
                }
         //   }
            //begin.await();
            end.countDown();
            System.out.println(" No." + end.getCount() + " end");
        }  finally {
            // 每个选手到达终点时，end就减一
           // end.countDown();
           // System.out.println(" No." + end.getCount() + " end");
        }
    }
}
