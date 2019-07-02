package com.github.arithmetic.structure;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/11 13:03
 * @Version 1.0
 */
public class ArrayStack {

    private static int[] array = new int[5];
    private static int size = 0;

    public static void main(String[] args) {


        for (int i = 0; i < 5; i++) {
            push(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(peek());
            System.out.println(pop());
        }
        System.out.println(peek());
    }

    private static void push(int ele){
        if (size == array.length){
            throw new RuntimeException("栈溢出");
        }
        array[size++] = ele;
    }

    private static int pop(){
        if (size < 0){
            throw new RuntimeException("栈空");
        }
        return array[--size];
    }

    private static Integer peek(){
        if (size == 0){
            return null;
        }
        return array[size - 1];
    }
}
