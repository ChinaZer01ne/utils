package com.github.concurrency.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/4 14:52
 */
public class CyclicBarrierTest2 {
    public static  int threadCount = 10;
    private static AtomicInteger i = new AtomicInteger(0);
    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadCount);

        ExecutorService service = Executors.newCachedThreadPool();

        long start = System.nanoTime();
        while (threadCount > 0){

            service.submit(()->{

                System.out.println(i.getAndIncrement());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                long end = System.nanoTime();

                System.out.println("finished" + (end - start));

            });
            threadCount--;
        }

        long end = System.nanoTime();
        System.out.println("time:" + (end - start));

    }
}
