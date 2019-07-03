package com.cc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by changc on 2018/9/12.
 @Configuration可理解为用spring的时候xml里面的<beans>标签

 @Bean可理解为用spring的时候xml里面的<bean>标签

 Spring Boot不是spring的加强版，所以@Configuration和@Bean同样可以用在普通的spring项目中，而不是Spring Boot特有的，只是在spring用的时候，注意加上扫包配置

 <context:component-scan base-package="com.xxx.xxx" />，普通的spring项目好多注解都需要扫包，才有用，有时候自己注解用的挺6，但不起效果，就要注意这点。

 Spring Boot则不需要，主要你保证你的启动Spring Boot main入口，在这些类的上层包就行

 */
//
@Configuration
@EnableAsync
public class AsyncConfig {
    /*
    此处成员变量应该使用@Value从配置中读取
    */
    @Value("${ThreadPool.corePoolSize}")
    private int corePoolSize;
    @Value("${ThreadPool.maxPoolSize}")
    private int maxPoolSize;
    @Value("${ThreadPool.queueCapacity}")
    private int queueCapacity;
    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.initialize();
        return executor;
    }
}
