package com.github.jvm;

/**
 * 对于接口变量的调用，并不会要求其父接口的初始化
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/9 17:55
 */
public class MyTest4{
    public static void main(String[] args) {
        System.out.println(MyChild4.b);
    }
}

interface MyParent4 {
    int a = 5;

}

interface MyChild4 extends MyParent4{
    int b = 6;
}
