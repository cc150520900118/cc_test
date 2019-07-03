package com.cc.SynchronizedDemo;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

/**
 * Created by admin on 2019/6/26.
 */
public class SynchronizedDemo {
    static int count = 0;//如果不用 static 则每一个对象创建的时候，都会赋值为 0 ，然后再加一次，只能是1
    public static void main(String[] args) {
        SynchronizedDemo demo1 = new SynchronizedDemo();
        // 修饰对象实列方法 锁定的当前实列对象 必须是公用同一个对象才行
        new Thread("thread1") {

            @Override
            public void run() {
                try {
                    demo1.demo1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread("thread2") {

            @Override
            public void run() {
                try {
                    demo1.demo1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    /**
     * 修饰实列方法
     *
     * @throws InterruptedException
     */
    public synchronized void demo1() throws InterruptedException {
        count++;
        System.out.println("当前访问的线程名称是====" + Thread.currentThread().getName());
        System.out.println("当前访问的线程名称是====" + count);
        //休眠2s 造成两个线程同时访问本实列方法
        Thread.sleep(2000);
    }
}