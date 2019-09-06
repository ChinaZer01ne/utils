package com.github.concurrency;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/9/6 14:51
 */
public class ThreadPractice {


    private static AtomicInteger count = new AtomicInteger(1);

    public static void main(String[] args) {


        AtomicInteger i = new AtomicInteger(5);

        ExecutorService service = Executors.newCachedThreadPool();

        ReentrantLock lock = new ReentrantLock();

        Condition gt5 = lock.newCondition();
        Condition lt5 = lock.newCondition();

        //for (int i = 1; i <= 50; i++) {

            service.submit(()->{
                while (true){
                    if (count.get() > 50){
                        break;
                    }

                    lock.lock();


                    try {
                        if (count.get() > i.get()){
                            lt5.await();
                        }
                        //if (count.get() > 50){break;}
                        System.out.println(Thread.currentThread().getName() + "-" + count.getAndIncrement());

                        if (count.get() > i.get()){
                            gt5.signal();
                        }

                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }


            });

            service.submit(()->{
                while (true){
                    if (count.get() > 50){
                        return;
                    }

                    lock.lock();

                    try {
                        if (count.get() < i.get()){
                            gt5.await();
                        }

                        System.out.println(Thread.currentThread().getName() + "-" + count.getAndIncrement());

                        if (count.get() % 10 == 1){
                            i.set(i.get() + 10);
                            lt5.signal();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        lock.unlock();
                    }
                }


            });
        //}

    }



}
