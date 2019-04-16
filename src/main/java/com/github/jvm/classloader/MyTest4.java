package com.github.jvm.classloader;

/**
 * 类的初始化不会引起接口的初始化
 * 对于接口常量的调用，并不会要求其父接口的初始化
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/9 17:55
 */
public class MyTest4{
    public static void main(String[] args) {
        //System.out.println(MyChild4.b);
        System.out.println(MyChildClass.c);
        //new C();
        //new C();
    }
}

class MyParent4 {
    int a = 5;
    public static Object object = new Object(){
        {
            System.out.println("myParent5 invoke");
        }
    };

}

//interface MyChild4 extends MyParent4{
//    int b = 6;
//}

class MyChildClass extends MyParent4{
    public static int c = 7;
    //public static final int c = 7;
}

class C{
    {
        System.out.println("class init");
    }
    public C(){
        System.out.println("C");
    }
}