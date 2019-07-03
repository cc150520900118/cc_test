package com.cc.SynchronizedDemo;

/**
 * Created by admin on 2019/6/26.
 *  * 注意一下"private String anyString = new String();"这句话，现在它是一个全局对象，
 * 因此监视的是同一个对象。如果移到try里面，那么对象的监视器就不是同一个了，调用的时候自然是异步调用，可以自己试一下。

 最后提一点，synchronized(非this对象x)，这个对象如果是实例变量的话，
 指的是对象的引用，只要对象的引用不变，即使改变了对象的属性，运行结果依然是同步的。
 */
public class ThreadDomain21
{
    private String userNameParam;
    private String passwordParam;
    private String anyString = new String();

    public void setUserNamePassword(String userName, String password)
    {
        try
        {
            synchronized (anyString)
            {
                System.out.println("线程名称为：" + Thread.currentThread().getName() +
                        "在 " + System.currentTimeMillis() + " 进入同步代码块");
                userNameParam = userName;
                Thread.sleep(3000);
                passwordParam = password;
                System.out.println("线程名称为：" + Thread.currentThread().getName() +
                        "在 " + System.currentTimeMillis() + " 离开同步代码块");
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}