package com.cc.util.threadreturn;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2019/4/19.
 */
public class ThreadPoolReturnTool<T> {

    //单个线程处理的数据量
    private int singleCount;
    //处理的总数据量
    private int listSize;
    //开启的线程数
    private int runSize;
    //操作的数据集
    private List<T> list;
    //线程池
    private ExecutorService executorService;
    //业务方法
    private Work work;

    //回调接口定义
    public interface Work<T>{
        public void method(List<T> list);
    }

    public ThreadPoolReturnTool(int singleCount, List<T> list){ //批量处理的数   data
        this.singleCount = singleCount;
        this.list = list;
        if (list != null){
            this.listSize = list.size();
            this.runSize = (this.listSize/this.singleCount) + 1;
        }
    }
    public void setWork(Work work) {
        this.work = work;
    }

    //执行
    public void excute() throws InterruptedException {
        System.out.println("主线程阻塞,等待所有子线程执行完成");
        //创建定长线程迟
        executorService = Executors.newFixedThreadPool(runSize);
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
                newList = list.subList(startIndex,endIndex);
            }
            //创建线程类处理数据
            MyThread myThread = new MyThread(newList) {
                @Override
                public void threadwork(List list) {
                    work.method(list);
                }
            };
            //执行线程
            executorService.execute(myThread);
        }
        executorService.shutdown();
    }
}