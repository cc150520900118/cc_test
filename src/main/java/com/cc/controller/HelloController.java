package com.cc.controller;


import com.cc.util.TestTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Future;

@Controller
public class HelloController {
    @Autowired
    private TestTask asyncTask;
    @ResponseBody
   @RequestMapping("/hello")
   public String hello() throws Exception {
        long starttime = System.currentTimeMillis();
        //Future<String> task1 = asyncTask.test1();
        //Future<String> task2 = asyncTask.test2(); //等待任务都执行完
        //Future<String> task3 = asyncTask.test3();
        for(int i=0;i<=30;i++){
             asyncTask.test2();
        }
       /*  while(true){
             if(task1.isDone() && task2.isDone()){ break;
             }
         }*/
       long endtime = System.currentTimeMillis();
        System.out.println("执行任务总用时：" + (endtime - starttime) + "毫秒");
       return "Hello World111!";
     }
}
