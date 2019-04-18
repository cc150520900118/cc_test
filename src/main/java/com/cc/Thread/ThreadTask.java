package com.cc.Thread;

import java.util.Random;

/**
 * Created by admin on 2019/4/16.
 *
 * 结论：A同学或者B同学，一个人先后拿走两把钥匙时，线程是正常运行的，
 * 一旦A拿了A锁进去A门的时候，CPU突然让B开始执行，让B拿了B锁进入B门，结果A需要B锁，B也需要A锁，两者又不能后退
   于是死锁现象发生了
 *同步锁使用的弊端：当线程任务中出现了多个同步(多个锁)时，
 * 如果同步中嵌套了其他的同步。这时容易引发一种现象：
 * 程序出现无限等待，这种现象我们称为死锁。这种情况能避免就避免掉。
 *
 *
 */
public class ThreadTask implements Runnable {
    int x = new Random().nextInt(1);//用随机数随机获取0、1，来模拟CPU随机分配执行权的行为

    @Override
    public void run() {
        while (true) {
            if (x % 2 == 0) {
                //情况一
//                先执行A再执行B：即A同学先拿了A门的钥匙去开A门，然后打算开B门
                synchronized (Lock.lockA) {
                    System.out.println("A同学...开A门");
                    synchronized (Lock.lockB) {
                        System.out.println("A同学...开B门");
                    }
                }
            } else {
                //情况二
//                先执行B执行A：B同学先拿了B门的钥匙，去开B门，然后打算开A门
                synchronized (Lock.lockB) {
                    System.out.println("B同学...开B门");
                    synchronized (Lock.lockA) {
                        System.out.println("B同学...开A门");
                    }
                }
            }
            x++;
        }

    }
    public static void main(String[] args) {
        //创建Runnable的实现类对象
        ThreadTask tt = new ThreadTask();
        //把Runnable实现类对象加入线程中，创建2个线程
        Thread t1 = new Thread(tt);
        Thread t2 = new Thread(tt);
        t1.start();
        t2.start();

    }
}