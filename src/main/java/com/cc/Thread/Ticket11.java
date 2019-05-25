package com.cc.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by admin on 2019/4/16.
 *
 * ticket结果中出现了负数和0，这就是线程安全问题，要怎么解决呢？
 　加同步锁 synchronized(Object o){....}  o可以是任意对象
 *http://www.importnew.com/21866.html    Callable  有返回值
 */
//加入同步锁后的代码   后台定时跑数据。
public class Ticket11 implements Runnable {
    //设置总票数为100，这里的ticket是成员变量，
    //由于在测试类中new了一次，所以值存在一个，被三个售票窗口共享
    int ticket = 100;
    List<String> list = new ArrayList<String>();
    public Ticket11( List<String> list) {
        this.list = list;
    }
    @Override
    public void run() {
        //模拟售票
        while (true) {
            //加入同步锁
            synchronized (this) {
                //如果票数大于0，继续售票
                if (ticket > 0) {
                    //为了让线程安全问题效果明显些，加入线程定时休眠Thread.sleep()
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //Thread.currentThread()是线程获取当前线程对象的方法    getName()获取调用者的线程名
                    System.out.println(Thread.currentThread().getName() + "正在售票:" + ticket--);
                    list.add(ticket + "");
                }
            }
            //return list;
        }
    }
    public static void main(String[] args)throws ExecutionException, InterruptedException {
        List<String> list = new ArrayList<String>();
        Ticket11 ticket = new Ticket11(list);
        //加入线程缓存池   返回值
        java.util.concurrent.ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Future<List> future =cachedThreadPool.submit(ticket,list);
        System.out.println("返回的结果  name: " + 222);
        System.out.println("返回的结果  name: " + future.get());
    /*    for (int t = 0; t < 3; t++) {//多线程批处理
            Future future =   cachedThreadPool.submit(ticket);
            System.out.println("获取返回值: "+future.get());
        }*/
        cachedThreadPool.shutdown();

    }
}