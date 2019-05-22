package com.github.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/21 16:19
 */
public class ListGC {

    public static void main(String[] args) {

        List<Dog> list = new ArrayList<>();

        //Dog dog = new Dog();
        list.add(new Dog());

        list = null;

        System.gc();

        try {
            System.out.println("sleep");
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }



}
class Dog{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("dog gc");
        super.finalize();
    }
}