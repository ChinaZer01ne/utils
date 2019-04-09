package com.github.jvm;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/9 17:31
 */
public class MyTest3 {
    public static void main(String[] args) {
        //MyParent3 myParent3 = new MyParent3();
        //不会导致初始化
        //MyParent3[] myParent3 = new MyParent3[1];
        //System.out.println(myParent3.getClass());
        String[] strs = new String[1];
    }
}

class MyParent3{
    static {
        System.out.println("myParent3 static code");
    }
}
