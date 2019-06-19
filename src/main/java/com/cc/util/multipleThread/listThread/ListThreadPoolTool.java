package com.cc.util.multipleThread.listThread;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2019/4/19.
 */
public class ListThreadPoolTool<T> {

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
        public void method(int xcmz, List<T> list);
    }

    public ListThreadPoolTool(int singleCount, List<T> list){ //批量处理的数   data
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
        executorService = Executors.newFixedThreadPool(runSize);
        //创建线程
        int startIndex = 0;
        int endIndex = 0;
        int xcmz=0;//线程名称
        List<T> newList = null;
        for (int i = 0; i < runSize; i++) {
            xcmz=i+1;
            //计算每个线程对应的数据
            if (i < (runSize - 1)){//每次批量处理
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
            MyThread myThread = new MyThread(xcmz,newList) {
                @Override
                public void threadwork(int xcmz,List list) {
                    work.method(xcmz,list);
                }
            };
            //执行线程
            executorService.execute(myThread);
        }
        executorService.shutdown();
    }
}