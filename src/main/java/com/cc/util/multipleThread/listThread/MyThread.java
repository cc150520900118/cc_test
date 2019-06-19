package com.cc.util.multipleThread.listThread;
import java.util.List;

/**
 * Created by admin on 2019/5/28.
 */
//抽象线程类
public abstract class    MyThread<T> implements Runnable{

    private List<T> list;
    private int xcmz;

    public MyThread(int xcmz,List<T> list){
        this.list = list;
        this.xcmz = xcmz;
    }
    public abstract void threadwork(int xcmz,List<T> list);
    @Override
    public void run() { //里面实现业务代码
        threadwork(xcmz,list);
    }
}
