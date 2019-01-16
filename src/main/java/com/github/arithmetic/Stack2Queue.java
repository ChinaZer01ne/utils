package com.github.arithmetic;

import java.util.Stack;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/11 17:16
 * @Version 1.0
 */
public class Stack2Queue {

    private static Stack<Integer> pushStack = new Stack<>();
    private static Stack<Integer> popStack = new Stack<>();

    public static void main(String[] args) {

        int[] arr = new int[]{5,1,26,23,33,12};

        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(poll());
        }
        add(3);
        add(2);
        System.out.println(peek());
        System.out.println(poll());
    }

    private static void add(Integer ele){
        pushStack.push(ele);
    }

    private static Integer poll(){
        pour();
        return popStack.pop();
    }

    private static Integer peek(){
        pour();
        return popStack.peek();
    }
    /**
     * 1、只有popStack没有数据的时候才能倒
     * 2、pushStack到popStack，要倒就倒完
     * */
    private static void pour() {
        if (popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        if (popStack.isEmpty()){
            throw new RuntimeException("队列为空");
        }
    }
}
