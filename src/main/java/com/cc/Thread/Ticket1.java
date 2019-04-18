package com.cc.Thread;

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
    int ticket = 100;

    public void run() {
        //模拟售票
        while (true) {
            //如果票数大于0，继续售票

            //加入同步锁
            synchronized (this) {
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
                }
            }
        }

    }
    public static void main(String[] args) {
        //创建Ticket的Runnable对象
        Ticket1 ticket = new Ticket1();
        //创建线程3个对象模拟三个售票窗口，并把Runnable对象加入Thread和给Thread命名
        new Thread(ticket,"窗口1").start();;
        new Thread(ticket,"窗口2").start();;
        new Thread(ticket,"窗口3").start();;

    }
}