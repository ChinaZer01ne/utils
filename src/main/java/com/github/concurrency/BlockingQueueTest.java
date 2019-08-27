package com.github.concurrency;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/27 16:03
 */
public class BlockingQueueTest {

    @Test
    public void test(){
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        System.out.println(blockingQueue.remainingCapacity());


        blockingQueue.offer(1);
        blockingQueue.offer(2);
        blockingQueue.offer(3);
        blockingQueue.offer(1);

        blockingQueue.remove(1);

        blockingQueue.forEach(System.out::println);

        ArrayList<Object> list = new ArrayList<>();
        list.add(10);
        blockingQueue.drainTo(list,2);
        System.out.println("=========");
        blockingQueue.forEach(System.out::println);
        System.out.println("=========");
        list.forEach(System.out::println);
    }
}
