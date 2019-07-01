package com.github.arithmetic;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/1 11:15
 */
public interface UF {
    int getSize();
    boolean isConnected(int p, int q);
    void unionElements(int p, int q);
}
