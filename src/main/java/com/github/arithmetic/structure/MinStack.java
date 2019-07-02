package com.github.arithmetic.structure;

import java.util.Stack;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/11 17:02
 * @Version 1.0
 */
public class MinStack {

    private static Stack<Integer> dataStack = new Stack<>();
    private static Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {
        int[] arr = new int[]{5,10,26,23,33,1};
        for (int ele:
             arr) {
            push(ele);
        }
        System.out.println(getMin());
        System.out.println(pop());
        System.out.println(getMin());
    }

    public static int getMin(){
        return minStack.peek();
    }

    public static void push(Integer ele){
        dataStack.push(ele);
        if (minStack.isEmpty()){
            minStack.push(ele);
        }else {
            minStack.push(ele < minStack.peek() ? ele : minStack.peek());
        }
    }

    public static Integer pop(){
        minStack.pop();
        return dataStack.pop();
    }
}
