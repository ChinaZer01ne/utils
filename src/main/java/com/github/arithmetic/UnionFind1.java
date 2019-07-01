package com.github.arithmetic;

/**
 * 并查集结构
 * 功能1、两个元素是否在一个集合中
 * 功能2、合并两个元素（不同集合）所在的集合
 * @Author: Zer01ne
 * @Date: 2019/2/12 15:05
 * @Version 1.0
 */
public class UnionFind1 implements UF{

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];

        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {

        int pIndex = find(p);
        int qIndex = find(q);

        if (pIndex == qIndex){
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == qIndex){
                id[i] = pIndex;
            }
        }
    }

    private int find(int p){
        if (p < 0 || p > id.length - 1){
            throw new IllegalArgumentException();
        }
        return id[p];
    }
}
