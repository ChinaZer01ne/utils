package com.github.basic;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>((o1, o2) ->  o2 - o1);
        queue1.add(1);
        queue1.add(2);
        queue1.add(3);
        queue1.add(4);
        queue1.add(5);
        while (!queue1.isEmpty()){
            System.out.println(queue1.poll());
        }
        System.out.println("============");
        queue2.add(1);
        queue2.add(2);
        queue2.add(3);
        queue2.add(4);
        queue2.add(5);
        while (!queue2.isEmpty()){
            System.out.println(queue2.poll());
        }
    }
}
