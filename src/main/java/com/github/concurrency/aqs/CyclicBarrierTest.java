package com.github.concurrency.aqs;

import java.util.concurrent.*;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/22 13:26
 */
public class CyclicBarrierTest {


    private static final int threadCount = 50;
    private static int m = 0;
    public static void main(String[] args) throws InterruptedException {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()-> {
            System.out.println("第" + m + "批任务完成");
            m++;
        });

        ExecutorService service = Executors.newCachedThreadPool();

        for (int i = threadCount; i > 0; i--) {
            final int threadNum = i;
            Thread.sleep(1000);
            service.execute(() ->{

                try {

                    System.out.println("ready execute " + threadNum);
                    cyclicBarrier.await();
                    System.out.println("continue execute " + threadNum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }

        System.out.println("finish");

    }
}
