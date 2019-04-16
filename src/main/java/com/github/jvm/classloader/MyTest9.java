package com.github.jvm.classloader;


public class MyTest9 {
    public static void main(String[] args) {
        System.err.println("boot: " + System.getProperty("sun.boot.class.path"));
        System.out.println("ext: " + System.getProperty("java.ext.dirs"));
        System.out.println("app: " + System.getProperty("java.class.path"));
        MyTest9 myTest9 = new MyTest9();
        System.out.println(myTest9.getClass().getClassLoader().getParent());
        System.out.println(ClassLoader.class.getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
