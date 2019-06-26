package com.github.arithmetic;


/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/26 10:47
 */
public interface MyQueue<T> {
    int getSize();
    boolean isEmpty();
    T dequeue();
    void enqueue(T t);
    T getFront();

}
