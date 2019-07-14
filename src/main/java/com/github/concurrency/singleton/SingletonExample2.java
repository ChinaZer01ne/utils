package com.github.concurrency.singleton;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingletonExample2 {
    public int i = 1;
    private static volatile SingletonExample2 single = null;

    private SingletonExample2(){}

    public static SingletonExample2 getInstance(){


            if (single == null){

                synchronized (SingletonExample1.class){
                    if (single == null){

                        single = new SingletonExample2();
                    }
                }
            }

        return single;
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);

        for (int i = 0; i < 10; i++) {

            executorService.submit(()->{
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                int a = SingletonExample2.getInstance().i;
                System.out.println(a);
            });

        }
    }
}
