package com.cc.util.wathread;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by admin on 2019/4/19.
 */
public class LatchThreadPoolTool<T> {

    //操作的数据集
    private List<T> list;

    private String wa;

    //计数器
    private CountDownLatch begin,end;
    //线程池
    private ExecutorService executorService;
    //回调
    private CallBack callBack;

    //回调接口定义
    public interface CallBack<T>{
        public void method(Map<String, Object> list);
    }

    public LatchThreadPoolTool( List<T> list){ //批量处理的数   data
        this.list = list;
    }


    public void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
    //执行
    public void excute() throws InterruptedException {
        System.out.println("主线程阻塞,等待所有子线程执行完成");
        //创建定长线程迟
        executorService = Executors.newFixedThreadPool(2);
        begin = new CountDownLatch(1);
        end = new CountDownLatch(1);
        //创建线程
        int startIndex = 0;
        int endIndex = 0;
        List<T> newList = null;
        for (int i = 0; i < 1; i++) {
            //创建线程类处理数据
            MyThread<T> myThread = new MyThread(list.get(i).toString(), begin, end) {
                @Override
                public void ywmethod(String wa) {
                    Map<String, String> reslutlist = new HashMap<>();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(Thread.currentThread().getName()+"---网安接口---"+list.get(i)+" ");
                        //调取结果

                        //存结果
                        reslutlist.put(i+"","网安接口"+list.get(i).toString());
                    }
                    callBack.method(reslutlist);//接口
                }
            };
            //执行线程
            executorService.execute(myThread);
        }
        //计数器减一  // 完成业务处理过程，计数器-1
        begin.countDown();
        end.await();//await() 方法在倒计数为0之前会阻塞当前线程.
        executorService.shutdown();
    }
}