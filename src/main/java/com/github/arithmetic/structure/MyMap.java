package com.github.arithmetic.structure;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/28 16:49
 */
public interface MyMap<K,V> {
    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key,V newValue);
    int getSize();
    boolean isEmpty();
}
