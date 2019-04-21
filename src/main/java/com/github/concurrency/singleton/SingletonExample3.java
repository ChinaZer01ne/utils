package com.github.concurrency.singleton;

public class SingletonExample3 {



    private SingletonExample3(){}

    public static SingletonExample3 getInstance(){
        return Singleton.INSTANCE.getInstance();
    }


    private enum Singleton{

        INSTANCE;

        private SingletonExample3 singleton;

        Singleton(){

            singleton = new SingletonExample3();

        }

        public SingletonExample3 getInstance(){
            return singleton;
        }
    }
}
