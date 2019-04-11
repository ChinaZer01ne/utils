package com.github.jvm;

public class MyCat {
    public MyCat() {
        System.out.println("MyCat Class loaded by " + getClass().getClassLoader());
    }
}
