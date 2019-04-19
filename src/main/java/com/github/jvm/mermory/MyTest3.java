package com.github.jvm.mermory;

/**
 * /**
 *  jconsole连接失败 加上运行参数： -Djava.rmi.server.hostname=localhost
 *
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/19 10:17
 */
public class MyTest3 {
    public static void main(String[] args) {
        new Thread(A::method,"线程A").start();
        new Thread(B::method,"线程B").start();
    }
}

class A {
    public static synchronized void method() {
        System.out.println("method from A");

        try {
            Thread.sleep(5000);
            B.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class B {
    public static synchronized void method() {
        System.out.println("method from B");


        try {
            Thread.sleep(5000);
            A.method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}