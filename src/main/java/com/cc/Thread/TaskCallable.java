package com.cc.Thread;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newCachedThreadPool;

/**
 * Created by admin on 2019/5/24.
 */
public class TaskCallable implements Callable<String> {
    private int id;
    public TaskCallable(int id){
        this.id = id;
    }
    @Override
    public String call() throws Exception {

        return "result of taskWithResult "+id;
    }
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ArrayList<String> results = new ArrayList<String>();//
        for(int i = 0 ; i < 10 ;i++){
            Future<String> future= cachedThreadPool.submit(new TaskCallable(i));//submit返回一个Future，代表了即将要返回的结果
            try {
                String  dd=future.get().toString();
                results.add(dd);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        System.out.println("多线程返回值"+results.toString());
       /* for(Future<String> ss:results ){
            try {
                System.out.println("多线程返回值"+ss.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }*/
    }
}
