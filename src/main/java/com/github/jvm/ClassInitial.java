package com.github.jvm;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/8 9:52
 */
public class ClassInitial {
    public static void main(String[] args) {
        //只有主动使用类的时候才会触发类的初始化
        System.out.println(Child.str1);
        //System.out.println(Child.str2);
    }
}


class Parent{

    public static String str1 = "parent-test";

    static {
        System.out.println("父类静态代码块");
    }
}

class Child extends Parent{

    public static String str2 = "child-test";

    static {
        System.out.println("子类静态代码块");
    }
}
