package com.github.concurrency.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

    private static  int threadCount = 50;
    private static CountDownLatch countDownLatch = new CountDownLatch(threadCount);

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        while (threadCount != 0){
            final int i = threadCount;
            service.execute(() -> {

                try {
                    System.out.println(i);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });

            threadCount--;
        }
        service.shutdown();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish");

    }
}
