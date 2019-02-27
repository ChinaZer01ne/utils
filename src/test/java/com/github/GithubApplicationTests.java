package com.github;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/27 14:44
 * @Version 1.0
 */
public class GithubApplicationTests {
    @Autowired
    private ThreadPoolTaskExecutor executor;

    @Test
    public void contextLoads() {
        // 线程池测试
        executor.execute(() -> System.out.println("this is runable " +Thread.currentThread().getName() + " thread in thread pool."));
        executor.submit(() -> {
            System.out.println("this is callable " +Thread.currentThread().getName() + " thread in thread pool.");
            return null;
        });
    }
}
