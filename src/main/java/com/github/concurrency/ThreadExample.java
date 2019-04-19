package com.github.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/19 14:44
 */
public class ThreadExample {

    //并发数量
    private static int threadCount = 200;
    //请求总数
    private static int request = 5000;

    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadCount);
        final CountDownLatch countDownLatch = new CountDownLatch(request);
        for (int i = 0; i < request; i++) {
            service.execute(()->{
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e){
                    e.printStackTrace();
                }
                countDownLatch.countDown();

            });
        }
        countDownLatch.await();
        service.shutdown();
        System.out.println(count);
    }

    private static void add(){
        count++;
    }
}
