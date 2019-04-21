package com.github.concurrency.vol;

public class VolatileTest3 extends Thread {

    private boolean isRunning = true;

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        this.isRunning = running;
    }

    @Override
    public void run() {
        System.out.println("进入到run方法");
        while (isRunning) {
        }
        System.out.println("run方法结束");
    }

    public static void main(String[] args) {
        try {
            VolatileTest3 thread = new VolatileTest3();
            thread.start();
            Thread.sleep(1000);
            thread.setRunning(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


