package com.cc.util.CyclicBarrier;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by admin on 2019/6/21.
 */
public class CyclicBarrierDemo {
    private static final ThreadPoolExecutor threadPool=new ThreadPoolExecutor(4,10,60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
    //1、当拦截线程数达到4时，便优先执行barrierAction，然后再执行被拦截的线程。
    //1、设置栅栏
    private static final CyclicBarrier cb=new CyclicBarrier(4,new Runnable() {
        public void run()
        {

            System.out.println("-------执行战法----------");
        }

    });
    //2、发送任务线程
    private static class GoThread extends Thread{
        private final String name;
        public GoThread(String name)
        {
            this.name=name;
        }
        public void run()
        {
            System.out.println(name+"发送");
            try {
                //Thread.sleep(1000);
                //开启多线程任务数据入库
                long startTime = System.currentTimeMillis();
                CountDownLatch latch = new CountDownLatch(3);
                ExecutorService executorService = Executors.newFixedThreadPool(10);
                System.out.println(name+"任务开始入库========================");
                for(int i = 0; i < latch.getCount(); i++){
                    executorService.execute(new SaveThread(latch,name));
                }
                //latch.await();
                latch.await(1,TimeUnit.SECONDS);//设置超时时间，设置了1秒   提前让主线程释放出来，继续执行下面的代码，执行完成后子线程再开始执行


//                任务2发送
//                任务1发送
//                任务3发送
//                任务4发送
//                任务2任务开始入库========================
//                任务3任务开始入库========================
//                任务4任务开始入库========================
//                任务1任务开始入库========================
//                超时时间===========1003
//                超时时间===========1003
//                超时时间===========1003
//                任务4任务已完成入库========================
//                超时时间===========1003
//                任务2任务已完成入库========================
//                任务3任务已完成入库========================
//                任务1任务已完成入库========================
//                -------执行战法----------
//                任务1执行战法完成
//                任务4执行战法完成
//                任务3执行战法完成
//                任务2执行战法完成
//                战法推算出结果
//                任务2 数据入库,所使用的时间为 1.763s
//                任务2 数据入库,所使用的时间为 1.709s
//                任务1 数据入库,所使用的时间为 1.882s
//                任务1 数据入库,所使用的时间为 2.471s
//                任务4 数据入库,所使用的时间为 1.069s
//                任务2 数据入库,所使用的时间为 2.274s
//                任务4 数据入库,所使用的时间为 1.157s
//                任务4 数据入库,所使用的时间为 2.301s
//                任务3 数据入库,所使用的时间为 1.234s
//                任务1 数据入库,所使用的时间为 1.574s
//                任务3 数据入库,所使用的时间为 2.393s
//                任务3 数据入库,所使用的时间为 2.586s

                long endTime=System.currentTimeMillis();
                System.out.println("超时时间==========="+(endTime - startTime));
                System.out.println(name+"任务已完成入库========================");
                try {
                    cb.await();//拦截线程
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
               // Thread.sleep(1000);
                System.out.println(name+"执行战法完成");

            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

   //数据入库
    private static class SaveThread implements Runnable{
        private CountDownLatch latch ;
       private String name ;
        public SaveThread(CountDownLatch latch,String name){
            this.latch = latch;
            this.name=name;
        }

        @Override
        public void run() {
            try {
                Random rand = new Random();
                int randomNum = rand.nextInt((3000 - 1000) + 1) + 1000;//产生1000到3000之间的随机整数
                Thread.sleep(5000);
                System.out.println(name+" 数据入库,所使用的时间为 "+((double)randomNum/1000)+"s");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] str= {"任务1","任务2","任务3","任务4"};
        for(int i=0;i<4;i++)
        {
            threadPool.execute(new GoThread(str[i]));
        }
        try
        {
            Thread.sleep(4000);
            System.out.println("战法推算出结果");
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }


    }
}
