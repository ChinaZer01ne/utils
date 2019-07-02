package com.github.arithmetic;

import org.apache.poi.ss.formula.functions.T;

import java.util.Stack;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/26 9:27
 */
public class MyArrayStack<T> implements MyStack<T> {

    private MyArrayList<T> array;

    public MyArrayStack() {
        this.array = new MyArrayList<>();
    }

    public MyArrayStack(int capacity) {
        this.array = new MyArrayList<>(capacity);
    }

    @Override
    public int getSize() {
        return array.size();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public T pop() {
        return array.removeLast();
    }

    @Override
    public void push(T t) {
        array.addLast(t);
    }

    @Override
    public T peek() {
        return array.getLast();
    }

    public int getCapacity(){
        return array.capacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack : [");
        for (int i = 0; i < array.size(); i++) {
            sb.append(array.get(i));
            if (i != array.size() - 1){
                sb.append(",");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}
