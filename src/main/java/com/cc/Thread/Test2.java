package com.cc.Thread;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by admin on 2019/5/24.
 */
public class Test2 {
    public static void main(String[] args) {
        long millis1 = System.currentTimeMillis();
        String fileName = "C:\\Users\\Administrator\\Desktop\\测试2.txt";
        int threadNum = 5;  //测试用的线程数目
        List<String> list = new ArrayList<String>();

        //创建一个缓存线程池
        java.util.concurrent.ExecutorService pool = Executors.newCachedThreadPool();
        for (int i = 0; i < threadNum; i++) {
            Callable<List<String>> myThread = new MyThread2("线程" + i, i, threadNum);
            Future<List<String>> future = pool.submit(myThread);
            try {
                list.addAll(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();  //不关闭的话，要等到超时程序才会结束

        Iterator<String> iterator = list.iterator();
        try {
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(new File(fileName)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            while(iterator.hasNext()){
                writer.write(iterator.next());
                writer.newLine();
                writer.flush();
            }
            writer.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        long millis2 = System.currentTimeMillis();
        System.out.println(millis2 - millis1);  //大约170-177ms
    }

}

/**
 * 自定义任务（线程）
 * */
class MyThread2 implements Callable<List<String>>{
    private String name; // 线程的名字
    private int i; // 第几个线程
    private int threadNum; // 总共创建了几个线程

    public MyThread2(String name, int i, int threadNum) {
        this.name = name;
        this.i = i;
        this.threadNum = threadNum;
    }

    public List<String> call() throws Exception {
        MyPrint2 myPrint2 = new MyPrint2();
        return myPrint2.print(name, i, threadNum);
    }


}

/**
 * 具体的业务操作
 * */
class MyPrint2 {

    public List<String> print(String name, int x, int threadNum) {
        List<String> list = new ArrayList<String>();

        for (int i = x; i <= 1000; i = i + threadNum) {
//			System.out.println(name + ": " + i + "----------------------------------我是一条华丽的小尾巴");
            list.add(name + ": " + i + "----------------------------------我是一条华丽的小尾巴");
        }
        return list;
    }

}
