package com.cc.util.multipleThread.postThread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2019/4/19.
 */
public class PostThreadPoolTool<T> {

    //处理的数据页数（请求次数）
    private int pages;
    //单个线程处理的数据量
    private int singleCount;
    //处理的总数据量
    private int listSize;
    //开启的线程数
    private int runSize;
    //线程池
    private ExecutorService executorService;
    //回调（接口）
    private Work work;

    //回调接口定义
    public interface Work<T>{
        public void method(int xzmc, int startIndex, int endIndex);
    }

    public PostThreadPoolTool(int singleCount, int pages){ //批量处理的数   data
        this.singleCount = singleCount;
        this.pages = pages;
        this.runSize = (this.pages/this.singleCount) +1;//22 5的批量  线程数5  4 个5  1个2

    }
    public void setWork(Work work) {
        this.work = work;
    }

    //执行
    public void excute() throws InterruptedException {
        //创建定长线程迟
        executorService = Executors.newFixedThreadPool(runSize);
        //创建线程
        int startIndex = 0;
        int endIndex = 0;
        int xcmz=0;//线程名称
        List<T> newList = null;
        for (int i = 1; i <=runSize; i++) {
            xcmz=i;
            //计算每个线程对应的数据
               if(i==1){
                   startIndex =1;
                   endIndex = 1* singleCount;
                   System.out.println("开启----第"+i+"个------线程：起始页：+"+startIndex+"结束页"+endIndex);
               }
               else if (i==runSize){
                   startIndex = (i-1)* singleCount+1;
                   endIndex =pages;
                   if(startIndex>endIndex){
                       return;
                   }else{
                       System.out.println("开启----第"+i+"个------线程：起始页：+"+startIndex+"结束页"+endIndex);
                   }
               }
               else {
                startIndex = (i-1)* singleCount+1;
                endIndex = i * singleCount;
                System.out.println("开启----第"+i+"个------线程：起始页：+"+startIndex+"结束页"+endIndex);
            }
            //创建线程类处理数据
            MyThread<T> myThread = new MyThread(xcmz,startIndex,endIndex) {
                @Override
                public void threadwork(int xcmz,int startIndex, int endIndex) {
                    work.method(xcmz,startIndex,endIndex);
                }
            };
            //执行线程
            executorService.execute(myThread);
        }
        executorService.shutdown();
    }
}