package com.cc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by changc on 2019/3/8.
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Autowired   //注入   logCostInterceptor
    private LogCostInterceptor logCostInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(logCostInterceptor).
                addPathPatterns("/**").
                excludePathPatterns("/cc/cookie");

    }
}