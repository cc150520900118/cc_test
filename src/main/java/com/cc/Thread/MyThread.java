package com.cc.Thread;

import java.lang.*;

/**
 * Created by changc on 2019/3/18.
 * 继承Thread类的，我们相当于拿出三件事即三个卖票10张的任务分别分给三个窗口，
 * 他们各做各的事各卖各的票各完成各的任务，因为MyThread继承Thread类，
 * 所以在new MyThread的时候在创建三个对象的同时创建了三个线程；
 *
 */
public class MyThread extends java.lang.Thread {

    private int ticket = 10;
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 500; i++) {
            if (this.ticket > 0) {
                System.out.println(this.name + "卖票---->" + (this.ticket--));
            }
        }
    }
    public static void main(String[] args) {
        MyThread mt1 = new MyThread("一号窗口");
        MyThread mt2 = new MyThread("二号窗口");
        MyThread mt3 = new MyThread("三号窗口");
        mt1.start();
        mt2.start();
        mt3.start();
    }
}