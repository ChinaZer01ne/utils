package com.github.jvm;

import java.lang.reflect.Method;

public class MyTest10 {
    public static void main(String[] args) throws Exception {

        MyClassLoader classLoader1 = new MyClassLoader("load1");
        MyClassLoader classLoader2 = new MyClassLoader("load1");

        classLoader1.setPath("C:\\Users\\Zer01ne\\Desktop\\");
        classLoader2.setPath("C:\\Users\\Zer01ne\\Desktop\\");

        Class<?> aClass1 = classLoader1.loadClass("com.github.jvm.MyPerson");
        Class<?> aClass2 = classLoader2.loadClass("com.github.jvm.MyPerson");
        System.out.println(aClass1 == aClass2);

        Object o1 = aClass1.getDeclaredConstructor().newInstance();
        Object o2 = aClass2.getDeclaredConstructor().newInstance();
        Method setMyParent = aClass1.getMethod("setMyPerson", Object.class);
        setMyParent.invoke(o1,o2);




    }
}
