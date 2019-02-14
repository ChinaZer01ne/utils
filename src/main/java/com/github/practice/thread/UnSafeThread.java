package com.github.practice.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/13 10:07
 * @Version 1.0
 */
public class UnSafeThread {
    public static void main(String[] args) throws InterruptedException {

        int threadNum = 1000;

        ExecutorService service = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        ObjectExample objectExample = new ObjectExample();
        for (int i = 0; i < threadNum; i++) {

            service.execute(new Runnable() {
                @Override
                public void run() {
                    objectExample.add();
                    //System.out.println(objectExample.get());
                }
            });
            countDownLatch.countDown();
        }
        countDownLatch.await();
        service.shutdown();
        System.err.println(objectExample.get());
    }
}

class ObjectExample{
    private int count = 0;


    public synchronized void add(){
        count++;
    }

    public synchronized int get(){
        return count;
    }
}
