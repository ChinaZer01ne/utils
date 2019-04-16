package com.github.jvm.classloader;

public class MyCat {
    public MyCat() {
        System.out.println("MyCat Class loaded by " + getClass().getClassLoader());
    }
}
