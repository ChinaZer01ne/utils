package com.github.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UnsafeHashMapTest {
    public static void main(String[] args) {
        unsafeConcurrentUpdate();
    }
    public static void unsafeConcurrentUpdate() {
        final Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < 1000; i++) {
            Thread t = new Thread() {
                Random rnd = new Random();
                @Override
                public void run() {
                    for(int i = 0; i < 1000; i++) {
                        map.put(rnd.nextInt(), 1);
                    }
                }
            };
            t.start();
        }
    }

}
