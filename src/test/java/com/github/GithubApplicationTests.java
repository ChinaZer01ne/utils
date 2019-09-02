package com.github;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ClassUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/27 14:44
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = GithubApplication.class)
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


    @Test
    public void getFile() throws FileNotFoundException {
        System.out.println(ClassUtils.getDefaultClassLoader().getResource("").getPath());
        File file = Paths.get(ResourceUtils.getURL("classpath:").getPath().substring(1)).toFile();
        for (File file1 : file.listFiles()) {
            System.out.println(file1.getName());
        }
        //System.out.println(System.getProperty("user.dir"));
    }
}
