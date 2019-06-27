package com.github.arithmetic;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/26 9:24
 */
public interface MyStack<T> {

    int getSize();
    boolean isEmpty();
    T pop();
    void push(T t);
    T peek();
}
