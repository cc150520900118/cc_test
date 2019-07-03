package com.cc.util.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2019/4/19.
 * CountDownLatch是一种简单的同步模式，它让一个线程可以等待一个或多个线程完成它们的工作从而避免对临界资源并发访问所引发的各种问题。
 使用场景:
 在一些应用场合中，需要等待某个条件达到要求后才能做后面的事情；
 同时当线程都完成后也会触发事件，以便进行后面的操作。
 这个时候就可以使用CountDownLatch。CountDownLatch最重要的方法是countDown()和await()，
 前者主要是倒数一次，后者是等 待倒数到0，如果没有到达0，就只有阻塞等待了。
 *
 *异步   并发
 *批量多线程   多线程 就是并发  批量就是异步处理数据量
 *总结一下，

 　　1、CountDownLatch end = new CountDownLatch(N); //构造对象时候 需要传入参数N

 　　2、end.await()  能够阻塞线程 直到调用N次end.countDown() 方法才释放线程

 　　3、end.countDown() 可以在多个线程中调用  计算调用次数是所有线程调用次数的总和
 *
 */
public class CountDownLatchTest {
        // 模拟了100米赛跑，10名选手已经准备就绪，只等裁判一声令下。当所有人都到达终点时，比赛结束。
        public static void main(String[] args) {
            // 开始的倒数锁
            final CountDownLatch begin = new CountDownLatch(1);
            // 结束的倒数锁
            final CountDownLatch end = new CountDownLatch(100);
            // 十名选手
            ExecutorService executorService = Executors.newFixedThreadPool(100);
            for (int i = 1; i <= 100; i++) {
                final int no = i;
                Runnable run = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            // 如果当前计数为零，则此方法立即返回。
                            // 等待
                           // begin.await();
                            Thread.sleep((long) (Math.random() * 10000L));
                            //System.out.println(" No." + no + " arrived");
                         //   System.out.println(" No." + begin.getCount() + " arrived");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            // 每个选手到达终点时，end就减一
                            end.countDown();
                            System.out.println(" No." + end.getCount() + " end");
                        }
                    }
                };
                executorService.execute(run);
            }

            System.out.println("Game start...");
            // begin减一，开始游戏
          //  begin.countDown();
            try {
                end.await();
                // 等待end变为0，即所有选手到达终点
                System.out.println("Game over...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }
    }
