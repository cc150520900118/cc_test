package com.cc.Thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by admin on 2019/4/19.
 */
public class MyThreadfanhui implements Runnable {
    Data data;

    public MyThreadfanhui(Data name) {
        this.data = name;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("线程  执行:");
            data.setName("新名字");
            data.setSex("新性别");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        java.util.concurrent.ExecutorService executor = Executors.newFixedThreadPool(3);
        Data data = new Data();
        Future<Data> future = executor.submit(new MyThreadfanhui(data), data);
        System.out.println("返回的结果  name: " + future.get().getName()+", sex: "+future.get().getSex());
        System.out.println("原来的Data  name: " + data.getName()+", sex: "+data.getSex());
    }
}
