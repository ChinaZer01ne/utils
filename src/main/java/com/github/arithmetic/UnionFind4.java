package com.github.arithmetic;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/1 12:18
 */
public class UnionFind4 implements UF {

    private int[] parent;
    private int[] rank;   //rank[i]表示以i为根的树的高度

    public UnionFind4(int size) {

        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
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
        //rank低的集合合并到rank高的集合
        if (rank[pParent] < rank[qParent]){
            parent[pParent] = qParent;
        }else if (rank[qParent] < rank[pParent]){
            parent[qParent] = pParent;
        }else {
            parent[qParent] = pParent;
            rank[pParent]++;
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
