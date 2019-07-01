package com.github.arithmetic;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/1 12:18
 */
public class UnionFind2 implements UF {

    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
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
        parent[pParent] = qParent;
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
