package com.cc.SynchronizedDemo;

/**
 * Created by admin on 2019/6/26.
 *
 *
 *
 */
public class MyThread21_0 extends Thread
{
    private ThreadDomain21 td;

    public MyThread21_0(ThreadDomain21 td)
    {
        this.td = td;
    }

    public void run()
    {
        td.setUserNamePassword("A", "AA");
    }
}