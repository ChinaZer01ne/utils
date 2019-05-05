package com.github.basic;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/5 10:09
 */
public class LinkedListTest {

    private static int count = 0;

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        ExecutorService service = Executors.newCachedThreadPool();


        while (count < 1000){

            service.execute(() ->{

                linkedList.add(1);
            });

            service.execute(() ->{

                linkedList.add(1);
            });

            count++;
        }

        System.out.println(linkedList.size());
    }
}
