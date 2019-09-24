package com.github.basic;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/9/24 9:26
 */
public class ConcurrentHashMapTest {


    public static final ConcurrentHashMap<String,Integer> MAP = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{

            int i = 0;
            while (i < 50){
                synchronized (MAP){
                    if (MAP.get("count") == null){
                        MAP.put("count",1);
                    } else {
                        MAP.put("count",MAP.get("count") + 1);
                    }
                    i++;
                }

            }

        });

        Thread t2 = new Thread(() -> {
            int j = 0;
            while (j < 50){
                synchronized (MAP){
                    if (MAP.get("count") == null) {
                        MAP.put("count", 1);
                    } else {
                        MAP.put("count", MAP.get("count") + 1);
                    }
                    j++;
                }

            }

        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(MAP.get("count"));

    }
}
