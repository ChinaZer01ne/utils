package com.github.utils.thread;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @Author: Zer01ne
 * @Date: 2018/12/6 16:05
 * @Version 1.0
 */
@Configuration
public class ThreadPoolConfig{

    @Value("${thread.corePoolSize}")
    private int corePoolSize;
    @Value("${thread.maximumPoolSize}")
    private int maximumPoolSize;
    @Value("${thread.keepAliveTime}")
    private int keepAliveTime;
    @Value("${thread.queueCapacity}")
    private int queueCapacity;
    @Value("${thread.threadNamePrefix}")
    private String threadNamePrefix;

    @Bean
    public ThreadPoolTaskExecutor executor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数
        executor.setCorePoolSize(corePoolSize);
        // 最大线程数
        executor.setMaxPoolSize(maximumPoolSize);
        executor.setAllowCoreThreadTimeOut(true);
        // 线程最大空闲时间
        executor.setKeepAliveSeconds(keepAliveTime);
        // 队列大小
        executor.setQueueCapacity(queueCapacity);
        // 拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        // 线程名称前缀
        executor.setThreadNamePrefix(threadNamePrefix);

        return executor;
    }


}
