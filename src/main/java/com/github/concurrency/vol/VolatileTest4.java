package com.github.concurrency.vol;

public class VolatileTest4 {
    private   VolatileTest3 test3 = new VolatileTest3();

    public static void main(String[] args) {
        VolatileTest4 test4 = new VolatileTest4();

        test4.test3.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        test4.test3.setRunning(false);
    }
}
