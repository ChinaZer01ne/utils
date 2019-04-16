package com.github.jvm.classloader;

public class MyTest12 implements Runnable {

    private Thread thread;


    public MyTest12() {
        this.thread = new Thread(this);
        thread.start();
    }

    public static void main(String[] args) {
        new MyTest12();


    }

    @Override
    public void run() {

        ClassLoader contextClassLoader = this.thread.getContextClassLoader();

        this.thread.setContextClassLoader(contextClassLoader);

        System.out.println("class : " + contextClassLoader.getClass());
        System.out.println("parent : " + contextClassLoader.getParent().getClass());

    }
}
