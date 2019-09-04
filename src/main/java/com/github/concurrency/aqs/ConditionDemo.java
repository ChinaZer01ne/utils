package com.github.concurrency.aqs;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/9/4 17:29
 */
public class ConditionDemo {

    private static ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args) {
        Condition condition = lock.newCondition();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                lock.lock();
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
            });
            thread.start();
        }
    }
}
