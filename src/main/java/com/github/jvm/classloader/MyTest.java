package com.github.jvm.classloader;


/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/9 16:20
 */
public class MyTest {
    public static void main(String[] args) {

        //System.out.println(MyParent.str);
        System.out.println(MyParent.test);
        //System.out.println(MyParent.testShort);
    }
}

class MyParent{

    //public static final String str = "parent-test";
    public static final int test = -2;
    //public static final short testShort = 127;

    static {
        System.out.println("父类静态代码块");

    }
}
