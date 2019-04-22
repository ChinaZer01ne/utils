package com.github.concurrency.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    private static  int threadCount = 200;


    public static void main(String[] args) {

        ExecutorService service = Executors.newCachedThreadPool();

        Semaphore semaphore = new Semaphore(3);

        while (threadCount > 0){

            final int i = threadCount;
            service.execute(() -> {
                try {
                    semaphore.acquire(3);
                    Thread.sleep(1000);
                    System.out.println(i);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    semaphore.release(3);
                }
            });

            threadCount--;
        }
        service.shutdown();

        System.out.println("finish");

    }
}
