package com.cc.util.multipleThread.latchThread;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2019/4/19.
 */
public class LatchThreadPoolTool<T> {

    //单个线程处理的数据量
    private int singleCount;
    //处理的总数据量
    private int listSize;
    //开启的线程数
    private int runSize;
    //操作的数据集
    private List<T> list;
    //计数器
    private CountDownLatch begin,end;
    //线程池
    private ExecutorService executorService;
    //回调
    private CallBack callBack;

    //回调接口定义
    public interface CallBack<T>{
        public void method(List<T> list);
    }

    public LatchThreadPoolTool(int singleCount, List<T> list){ //批量处理的数   data
        this.singleCount = singleCount;
        this.list = list;
        if (list != null){
            this.listSize = list.size();
            this.runSize = (this.listSize/this.singleCount) + 1;
        }
    }


    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
    //执行
    public void excute() throws InterruptedException {
        System.out.println("主线程阻塞,等待所有子线程执行完成");
        //创建定长线程迟
        executorService = Executors.newFixedThreadPool(runSize);
        begin = new CountDownLatch(1);
        end = new CountDownLatch(runSize);
        //创建线程
        int startIndex = 0;
        int endIndex = 0;
        List<T> newList = null;
        for (int i = 0; i < runSize; i++) {
            //计算每个线程对应的数据
            if (i < (runSize - 1)){
                startIndex = i * singleCount;
                endIndex = (i + 1) * singleCount;
                newList = list.subList(startIndex,endIndex); //从fromIndex（包含），到toIndex（不包含）
            }else {
                startIndex = i * singleCount;
                endIndex = listSize;
                if(i * singleCount==listSize){//处理没有余数的情况 //避免开启一个空线程跑
                    return;
                }else{
                    newList = list.subList(startIndex,endIndex);//最后一次批量处理
                }
            }
            //创建线程类处理数据
            MyThread<T> myThread = new MyThread(newList, begin, end) {
                @Override
                public void ywmethod(List list) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"------"+list.size()+" ");
                    callBack.method(list);//接口
                }
            };
            //执行线程
            executorService.execute(myThread);
        }
        //计数器减一  // 完成业务处理过程，计数器-1
        System.out.println("游戏开始22222开始");
        begin.countDown();
        end.await();//await() 方法在倒计数为0之前会阻塞当前线程.
        System.out.println("游戏结束333333");
        executorService.shutdown();
    }
}