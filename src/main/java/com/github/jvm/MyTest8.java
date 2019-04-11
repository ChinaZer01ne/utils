package com.github.jvm;

public class MyTest8 {
    public static void main(String[] args) throws Exception {
        MyClassLoader classLoader = new MyClassLoader("load1");
        classLoader.setPath("C:\\Users\\Zer01ne\\Desktop\\");
        Class<?> aClass = classLoader.loadClass("com.github.jvm.MySample");
        System.out.println("class:" + aClass.hashCode());

        Object o = aClass.getDeclaredConstructor().newInstance();
    }
}
