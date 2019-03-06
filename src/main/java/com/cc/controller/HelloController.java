package com.cc.controller;


import com.cc.util.TestTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
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
        for (int i = 0; i <= 30; i++) {
            asyncTask.test2();
            // System.out.println(ss);
        }
       /*  while(true){
             if(task1.isDone() && task2.isDone()){ break;
             }
         }*/
        long endtime = System.currentTimeMillis();
        System.out.println("执行任务总用时：" + (endtime - starttime) + "毫秒");
        return "Hello World111!";
    }

    @ResponseBody
    @RequestMapping("/hi")
    public Map<String, Object> testAsyncReturn() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        Map<String, Object> map = new HashMap<>();
        List<Future<String>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Future<String> future = asyncTask.doReturn(i);
            futures.add(future);
        }
        List<String> response = new ArrayList<>();
        for (Future future : futures) {
            String string = (String) future.get();
            response.add(string);
        }
        map.put("data", response);
        map.put("消耗时间", String.format("任务执行成功,耗时{%s}毫秒", System.currentTimeMillis() - start));
        return map;
    }
    @ResponseBody
    @GetMapping("/cookie")
    public String hello(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        Cookie[] cookies = httpServletRequest.getCookies();
        String res="";
        httpServletRequest.getSession().setAttribute("user","cc");
        //第一次访问 cookies方法，返回Response 中会产生JSESSIONID
        //Set-Cookie:JSESSIONID=5D06821C5E7AC3D8F7E5904E3FF4FD95; Path=/; HttpOnly

        //第二次访问 cookies方法 客户端Request请求会带着
        //Cookie:JSESSIONID=5D06821C5E7AC3D8F7E5904E3FF4FD95,
        if (cookies != null) {//只有第二次才会进入
            // 1、Domain:localhost  Path:/   新建同名的会写不进 （所以在设置cookie的时候尽量不要用localhost,特别是两个项目同域时）
            for (Cookie cookie : cookies) {
                //JSESSIONID tomcat生成的sessionid叫做jsessionid。
                if ("JSESSIONID".equals(cookie.getName())) {
                    res=cookie.getValue();
                    // c1 同域名同cookie名，不同path
                    javax.servlet.http.Cookie c1 = new javax.servlet.http.Cookie("JSESSIONID", "4444");
                    c1.setPath("/cc");
                    // c2 同域名同cookie名，同path，直接替换了JSESSIONID
                    javax.servlet.http.Cookie c2= new javax.servlet.http.Cookie("JSESSIONID", "5555");
                    c2.setPath("/");
                    httpServletResponse.addCookie(c1);
                    httpServletResponse.addCookie(c2);//响应返回cookie*/
                }
            }
        }
        return res;
    }
}