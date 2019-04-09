package com.github.jvm;

public class MyTest5 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        System.out.println("counter1 : " + Singleton.counter1);
        System.out.println("counter2 : " + Singleton.counter2);
    }
}

class Singleton{
    public static int counter1;

    private static Singleton singleton = new Singleton();
    private Singleton(){
        counter1++;
        counter2++;

    }
    //初始化的时候赋值成了0
    public static int counter2 = 0;

    public static Singleton getInstance(){
        return singleton;
    }
}
