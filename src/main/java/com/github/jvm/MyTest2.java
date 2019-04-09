package com.github.jvm;

import java.util.UUID;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/9 17:19
 */
public class MyTest2 {
    public static void main(String[] args) {
        System.out.println(MyParent2.str);
    }
}

class MyParent2{

    public static final String str = UUID.randomUUID().toString();

    static {
        System.out.println("MyParent2 static code");
    }
}
