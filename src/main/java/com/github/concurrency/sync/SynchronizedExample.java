package com.github.concurrency.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/19 16:48
 */
public class SynchronizedExample {

    public synchronized void test1() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Test1 - " + i);
        }
    }

    public void test2(){
        synchronized(this){
            for (int i = 0; i < 10; i++) {
                System.out.println("Test2 - " + i);
            }
        }
    }

    public static synchronized void test3(){
        for (int i = 0; i < 10; i++) {
            System.out.println("Test3 - " + i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample example = new SynchronizedExample();

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> {example.test1();});
        service.execute(() -> {example.test2();});
        service.execute(() -> {SynchronizedExample.test3();});

    }
}
