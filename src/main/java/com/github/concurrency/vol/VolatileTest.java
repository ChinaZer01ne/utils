package com.github.concurrency.vol;

import java.util.ArrayList;
import java.util.List;

public class VolatileTest {

    private static volatile boolean ready = true;
    //private static boolean ready = true;
    private static int number;
    private static int b;

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while (ready){
                //System.out.println(number);
                //int a = 1;
                //b = a;
                //b = 2;
            }
            //System.out.println(number);
        }
    }


    public static void main(String[] args) {

        new ReaderThread().start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        number = 42;    //线程并没有打印42，而直接停止了说明，此处出现了指令重排

        ready = false;
        //ready = !ready;

        System.out.println(b);
    }

}
