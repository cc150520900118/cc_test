package com.cc.util.threadreturn;

import java.util.List;

/**
 * Created by admin on 2019/5/28.
 */
//抽象线程类
public abstract class MyThread<T> implements Runnable{

    private List<T> list;


    public MyThread(List<T> list){
        this.list = list;
    }
    public abstract void threadwork(List<T> list);
    @Override
    public void run() { //里面实现业务代码
        threadwork(list);
    }
}
