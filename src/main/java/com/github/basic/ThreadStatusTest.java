package com.github.basic;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/9/24 10:27
 */
public class ThreadStatusTest {

    public static void main(String[] args) {

        Object lock = new Object();

        Thread t1 = new Thread(() -> {
            /** RUNNABLE*/
            System.out.println("start");

            //try {
            /** TIMED_WAITING*/
            //    Thread.sleep(5000);
            //} catch (InterruptedException e) {
            //    e.printStackTrace();
            //}

            synchronized (lock){

                try {
                    /** WAITING*/
                    lock.wait();
                    /** TIMED_WAITING*/
                    //lock.wait(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("end");
        });

        t1.start();
        System.out.println(t1.getState());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(t1.getState());

    }
}
