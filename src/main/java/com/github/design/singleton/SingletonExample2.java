package com.github.design.singleton;

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

}
