package com.github.arithmetic;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/28 16:03
 */
public interface MySet<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
