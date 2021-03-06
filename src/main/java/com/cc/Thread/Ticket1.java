package com.cc.Thread;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by admin on 2019/4/16.
 *
 * ticket结果中出现了负数和0，这就是线程安全问题，要怎么解决呢？
 　加同步锁 synchronized(Object o){....}  o可以是任意对象
 *http://www.importnew.com/21866.html
 */
//加入同步锁后的代码
public class Ticket1 implements Runnable {
    //设置总票数为100，这里的ticket是成员变量，
    //由于在测试类中new了一次，所以值存在一个，被三个售票窗口共享
    List<String> list = new ArrayList<>();
    int ticket=100;
/*    public Ticket1(List<String> list){
        this.list=list;
        this.ticket=list.size();
    }*/
    public void run() {
        //模拟售票
        while (true) {
            //如果票数大于0，继续售票
            //加入同步锁
            synchronized (this) {
                if (ticket >= 0) {
                    //为了让线程安全问题效果明显些，加入线程定时休眠Thread.sleep()
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    //list.remove(ticket);
                    //Thread.currentThread()是线程获取当前线程对象的方法    getName()获取调用者的线程名
                    System.out.println(Thread.currentThread().getName() + "正在处理:" + ticket--);
                }
            }
        }

    }
    public static void main(String[] args)throws ExecutionException, InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {//多线程批处理
            list.add(i+"");
        }
        //创建Ticket的Runnable对象
        Ticket1 ticket = new Ticket1();
        //加入线程缓存池   返回值
        java.util.concurrent.ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int t = 0; t < 3; t++) {//多线程批处理
            Thread thread= new Thread(ticket,"窗口"+t);//将runable 实例用做构造thread的参数
            cachedThreadPool.submit(ticket);
        }
        System.out.println(list.toString());
        cachedThreadPool.shutdown();

    }
}