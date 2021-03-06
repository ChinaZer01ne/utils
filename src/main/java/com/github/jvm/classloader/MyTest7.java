package com.github.jvm.classloader;

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
        Class<?> bClass = Class.forName("com.github.jvm.classloader.B");
        ClassLoader classLoader2 = bClass.getClassLoader();
        System.out.println(classLoader2);

        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(loader.loadClass("com.github.jvm.classloader.B"));

        String[] strs = new String[3];
        System.out.println(strs.getClass().getClassLoader());

        B[] bs = new B[3];
        System.out.println(bs.getClass().getClassLoader());
    }
}

class B{

 }

