package com.github.concurrency.vol;

public class VolatileTest2 {

    private static boolean ready = false;
    private static int number;

    private static class ReaderThread extends Thread{
        @Override
        public void run() {
            while (!ready){
                //Thread.yield();
                //System.out.println(1);
            }
            System.out.println(number);
        }
    }


    public static void main(String[] args) {

        new ReaderThread().start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        number = 42;

        ready = true;
    }

}

