package com.cc.Thread;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by admin on 2019/4/19.
 */
public class ExecutorService {

        public static void main(String[] args) throws ExecutionException, InterruptedException {
            java.util.concurrent.ExecutorService executor = Executors.newFixedThreadPool(3);
            //创建一个Callable，3秒后返回String类型
            Callable myCallable = new Callable() {
                @Override
                public String call() throws Exception {
                    Thread.sleep(3000);
                    System.out.println("calld方法执行了");
                    return "call方法返回值";
                }
            };
            System.out.println("提交任务之前 "+getStringDate());
            Future future = executor.submit(myCallable);
            System.out.println("提交任务之后，获取结果之前 "+getStringDate());
            System.out.println("获取返回值: "+future.get());
            System.out.println("获取到结果之后 "+getStringDate());
        }
        public static String getStringDate() {
            Date currentTime = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
            String dateString = formatter.format(currentTime);
            return dateString;
        }



}
