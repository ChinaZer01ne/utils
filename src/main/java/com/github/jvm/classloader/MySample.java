package com.github.jvm.classloader;

public class MySample {
    public MySample() {
        System.out.println("MySample Class loaded by " + getClass().getClassLoader());
        MyCat myCat = new MyCat();
    }
}
