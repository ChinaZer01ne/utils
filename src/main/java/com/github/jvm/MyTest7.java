package com.github.jvm;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/10 10:39
 */
public class MyTest7 {
    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("java.lang.String");
        ClassLoader classLoader = aClass.getClassLoader();
        System.out.println(classLoader);
        Class<?> bClass = Class.forName("com.github.jvm.B");
        ClassLoader classLoader2 = bClass.getClassLoader();
        System.out.println(classLoader2);

        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader.loadClass("com.github.jvm.B"));
    }
}

class B{

 }

