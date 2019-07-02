package com.github.arithmetic.structure;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/1 12:18
 */
public class UnionFind3 implements UF {

    private int[] parent;
    private int[] sz;   //sz[i]表示以i为根的集合中元素个数

    public UnionFind3(int size) {

        parent = new int[size];
        sz = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }


    @Override
    public int getSize() {
        return parent.length;
    }

    @Override
    public boolean isConnected(int p, int q) {

        return findParent(p) == findParent(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pParent = findParent(p);
        int qParent = findParent(q);
        if (qParent == pParent){
            return;
        }

        if (sz[pParent] < sz[qParent]){
            parent[pParent] = qParent;
            sz[qParent] +=  sz[pParent];
        }else {
            parent[qParent] = pParent;
            sz[pParent] += sz[qParent];
        }


    }

    private int findParent(int p){

        if (p < 0 || p > parent.length - 1){
            throw new IllegalArgumentException();
        }

        while (parent[p] != p){
            p = parent[p];
        }
        return p;
    }
}
