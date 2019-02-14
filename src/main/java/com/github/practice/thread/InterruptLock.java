package com.github.practice.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

/**
 * lock中断锁
 * @Author: Zer01ne
 * @Date: 2019/2/14 9:35
 * @Version 1.0
 */
public class InterruptLock {

    private static int count = 0;
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        //ExecutorService service = Executors.newCachedThreadPool();
        //service.execute(()->{
        //
        //    try {
        //        add();
        //        throw new InterruptedException();
        //    } catch (InterruptedException e) {
        //        e.printStackTrace();
        //    }
        //});
        //service.shutdown();
        AtomicLong t1Time = new AtomicLong();
        AtomicLong t2Time = new AtomicLong();

        Thread t1 = new Thread(()->{

            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "获取锁，print()");
                t1Time.set(System.currentTimeMillis());
                TimeUnit.SECONDS.sleep(5);
                print();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Thread sleep interrupt");
            }finally {
                lock.unlock();
            }


        });
        Thread t2 = new Thread(()->{
            lock.lock();
            t2Time.set(System.currentTimeMillis());
            print();
            lock.unlock();
        });
        long threadStartTime = System.currentTimeMillis();
        Thread t3 = new Thread(()->{
            while (true){
                //System.out.println(t1Time.get());
                //System.out.println(t2Time.get());
                if (t2Time.get() - t1Time.get() > 5000){
                    //System.out.println("打断");
                    t2.interrupt();
                }
            }
        });
        t3.setDaemon(true);
        t3.start();
        t1.start();
        t2.start();

        //t1.interrupt();

        //t2.interrupt();
    }

    public static synchronized void add(){
        count++;
    }

    public static  void print()  {
        try {
            lock.lockInterruptibly();
            TimeUnit.SECONDS.sleep(1);
            System.out.println("等待结束，继续执行");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "等待时间过长" + count);
        }finally {
            lock.unlock();
        }


    }
}
