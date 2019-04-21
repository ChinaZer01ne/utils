package com.github.concurrency.vol;

public class VolatileTest {

    private static boolean ready = true;
    private static int number;

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while (ready){
                System.out.println(number);
            }
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
    }

}
