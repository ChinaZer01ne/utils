package com.github.concurrency.singleton;

public class SingletonExample2 {

    private static  SingletonExample2 single = null;

    private SingletonExample2(){}

    public static SingletonExample2 getInstance(){


            if (single == null){

                synchronized (SingletonExample1.class){
                    if (single == null){

                        single = new SingletonExample2();
                    }
                }
            }

        return single;
    }

    public static void main(String[] args) {

    }
}
