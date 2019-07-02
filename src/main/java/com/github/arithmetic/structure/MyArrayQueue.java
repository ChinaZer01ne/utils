package com.github.arithmetic.structure;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/26 10:48
 */
public class MyArrayQueue<T> implements MyQueue<T> {

    private MyArrayList<T> array;

    public MyArrayQueue(){
        array = new MyArrayList<>();
    }

    public MyArrayQueue(int capacity){
        array = new MyArrayList<>(capacity);
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
    public T dequeue() {
        return array.removeFirst();
    }

    @Override
    public void enqueue(T t) {
        array.addLast(t);
    }

    @Override
    public T getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack : front [");
        for (int i = 0; i < array.size(); i++) {
            sb.append(array.get(i));
            if (i != array.size() - 1){
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
