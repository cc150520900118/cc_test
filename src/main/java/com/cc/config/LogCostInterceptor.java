package com.cc.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by changc on 2019/3/8.
 * 拦截器
 */

//@component （把普通pojo实例化到spring容器中，相当于配置文件中的
//<bean id="" class=""/>）
// 泛指各种组件，就是说当我们的类不属于各种归类的时候（不属于@Controller、@Services等的时候），
// 我们就可以使用@Component来标注这个类。
@Component
public class LogCostInterceptor implements HandlerInterceptor {
    long start = System.currentTimeMillis();
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        start = System.currentTimeMillis();
        System.out.println("----------------------->拦截器被创建");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("Interceptor cost="+(System.currentTimeMillis()-start));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("----------------------->拦截器被创建");
    }
}