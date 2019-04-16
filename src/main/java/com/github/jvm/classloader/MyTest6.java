package com.github.jvm.classloader;

public class MyTest6 {
    static int a = 1;
    static {
        a = 2;
    }
    static {
        a = 3;
    }

    public static void main(String[] args) {
        System.out.println(a);
    }
}
