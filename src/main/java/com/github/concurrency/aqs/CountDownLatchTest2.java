package com.github.concurrency.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/4 14:34
 */
public class CountDownLatchTest2 {

    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(10);
    private static final AtomicInteger count = new AtomicInteger();
    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();


        for (int i = 0; i < 10; i++) {
            service.submit(()->{
                try {
                    COUNT_DOWN_LATCH.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count.incrementAndGet();
            });
            COUNT_DOWN_LATCH.countDown();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count);
    }

}
