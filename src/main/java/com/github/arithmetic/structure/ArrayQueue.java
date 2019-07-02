package com.github.arithmetic.structure;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/11 13:25
 * @Version 1.0
 */
public class ArrayQueue {

    private static int[] array = new int[5];
    private static int start = 0;
    private static int end = 0;
    private static int size = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            queue(i);
        }
        System.out.println(dequeue());
        System.out.println(dequeue());
        queue(23);
        queue(10);
        for (int i = 0; i < 5; i++) {
            System.out.println(peek());
            System.out.println(dequeue());
        }
        queue(11);
        System.out.println(dequeue());
        queue(12);
        System.out.println(dequeue());
        queue(13);
        System.out.println(dequeue());
        System.out.println(start);
        System.out.println(end);
        System.out.println(size);
    }

    private static void queue(int ele){
        if (size == array.length){
            throw new RuntimeException("队列已满");
        }

        array[end = end % array.length] = ele;
        end++;
        size++;
    }

    private static Integer dequeue(){
        if (size == 0){
            throw new RuntimeException("队列为空");
        }
        int ele = array[start = start % array.length];
        size--;
        start++;
        return ele;

    }

    private static Integer peek(){
        if (size == 0){
            throw new RuntimeException("队列为空");
        }
        return array[start % array.length];
    }
}
