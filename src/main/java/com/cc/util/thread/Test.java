package com.cc.util.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by admin on 2019/5/29.
 */
public class Test {
    public static void main(String[] args) {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(2);

        for(int i=0; i<2; i++){
            Thread thread = new Thread(new Player(begin,end));
            thread.start();
        }

        try{
            System.out.println("the race begin");
            begin.countDown();
            //end.await();可以看到主线程没有等待代表选手的线程结束，直接宣布比赛结束了！刚开始就结束的比赛- -
            //这里可以看出，await() 方法具有阻塞作用
            //end.await()  能够阻塞线程 直到调用N次end.countDown() 方法才释放线程
            end.await();
         //1、CountDownLatch end = new CountDownLatch(N); //构造对象时候 需要传入参数N

          //3、end.countDown() 可以在多个线程中调用  计算调用次数是所有线程调用次数的总和
            System.out.println("the race end");
        }catch(Exception e){
            e.printStackTrace();
        }

    }
   /* public static void main(String[] args)
    {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(2);

        Thread thread = new Thread(new Player(begin, end));
        thread.start();

        Thread thread2 = new Thread(new Player2(begin, end));
        thread2.start();

        try
        {
            System.out.println("the race begin");
            begin.countDown();
            end.await();
            System.out.println("the race end");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }*/
}
