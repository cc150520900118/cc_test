package com.cc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * Created by changc on 2018/9/12.
 */
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
