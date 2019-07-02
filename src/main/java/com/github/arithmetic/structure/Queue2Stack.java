package com.github.arithmetic.structure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/11 17:16
 * @Version 1.0
 */
public class Queue2Stack {

    private static Queue<Integer> firstQueue = new LinkedList<>();
    private static Queue<Integer> secondQueue = new LinkedList<>();

    public static void main(String[] args) {
        int[] arr = new int[]{5,1,26,23,33,12};

        for (int i = 0; i < arr.length; i++) {
            push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(pop());
            System.out.println(" The top is " + peek());
        }
    }

    private static void push(Integer ele){
        firstQueue.add(ele);
    }

    private static Integer pop(){
        if (firstQueue.isEmpty()){
            throw new RuntimeException("栈空");
        }

        while (firstQueue.size() - 1 != 0){
            secondQueue.add(firstQueue.poll());
        }

        Integer ele = firstQueue.poll();

        swap();

        return ele;
    }

    private static Integer peek(){

        if (firstQueue.isEmpty()){
            return null;
        }

        while (firstQueue.size() - 1 != 0){
            secondQueue.add(firstQueue.poll());
        }

        Integer ele = firstQueue.peek();
        secondQueue.add(firstQueue.poll());

        swap();

        return ele;
    }

    private static void swap() {
        Queue<Integer> tempQueue = secondQueue;
        secondQueue = firstQueue;
        firstQueue = tempQueue;
    }
}
