package com.github.utils;

import com.github.utils.thread.ThreadPoolConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UtilsApplicationTests {

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
