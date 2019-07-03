package com.cc.util.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 总结：CountDownLatch和CyclicBarrier都有让多个线程等待同步然后再开始下一步动作的意思，
 * 但是CountDownLatch的下一步的动作实施者是主线程，具有不可重复性；而CyclicBarrier的下一步动作实施者还是“其他线程”本身，
 * 具有往复多次实施动作的特点。
 *
 *
 * 1.CountDownLatch是线程组之间的等待，即一个(或多个)线程等待N个线程完成某件事情之后再执行；而CyclicBarrier则是线程组内的等待，即每个线程相互等待，即N个线程都被拦截之后，然后依次执行。

 2.CountDownLatch是减计数方式，而CyclicBarrier是加计数方式。

 3.CountDownLatch计数为0无法重置，而CyclicBarrier计数达到初始值，则可以重置。

 4.CountDownLatch不可以复用，而CyclicBarrier可以复用。
 *
 *
 */
public class CyclicBarrierTest{

    private static final int SIZE = 5; //创建子线程的数量

    public static void main(String[] args) {
        //创建关卡对象
        CyclicBarrier cb = new CyclicBarrier(SIZE, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + " all sub thead end");//所有子线程执行完毕时执行
            }});
        //创建并启动五个子线程
        for(int i = 0; i < SIZE; i++) {
            new Thread(new SubThread(cb)).start();
        }
    }

    static class SubThread implements Runnable{

        private CyclicBarrier cb; //栅栏对象

        public SubThread(CyclicBarrier cb) {
            this.cb = cb;
        }

        @Override
        public void run() {
            //当前线程开始运行
            System.out.println(Thread.currentThread().getName() + ": sub thread starting running");
            try {
                cb.await();//计数器加1，等待其他线程执行到同样的地方
                //子线程全部继续执行
                System.out.println(Thread.currentThread().getName() + ":" +" all sub thread start doing other things");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}