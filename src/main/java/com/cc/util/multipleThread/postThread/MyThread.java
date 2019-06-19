package com.cc.util.multipleThread.postThread;

/**
 * Created by admin on 2019/5/28.
 */
//抽象线程类
public abstract class MyThread<T> implements Runnable{


    private int startIndex,endIndex,xcmz;

    public MyThread(int xcmz,int startIndex,int endIndex){
        this.xcmz = xcmz;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }
    public abstract void threadwork(int xcmz,int startIndex,int endIndex);
    @Override
    public void run() {
        threadwork(xcmz,startIndex,endIndex);
    }
}
