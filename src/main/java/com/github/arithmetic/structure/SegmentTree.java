package com.github.arithmetic;

public class SegmentTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;
    public SegmentTree(E[] arr,Merger<E> merger){
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        //线段树需要4倍的空间
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0,0,arr.length - 1);
    }

    private void buildSegmentTree(int treeIndex,int l, int r) {
        if (l == r){
            tree[treeIndex] = data[l];
        }
        int leftChild = leftChild(treeIndex);
        int rightChild = leftChild(treeIndex);

        int mid = l + (r - l) / 2;

        buildSegmentTree(leftChild,l,mid);
        buildSegmentTree(rightChild,mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftChild], tree[rightChild]) ;
    }

    public E get(int index){
        if (index < 0 || index > data.length){
            throw new IllegalArgumentException();
        }
        return data[index];
    }

    public E query(int queryL,int queryR){
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length){
            throw new IllegalArgumentException();
        }

        return query(0,0,data.length - 1,queryL,queryR);
    }
    //在以treeIndex为根的线段树中 {l-r}范围内，搜索区间 {queryL-queryR}的值
    private E query(int treeIndex, int l, int r,int queryL,int queryR){
        if (l == queryL && r == queryR){
            return tree[treeIndex];
        }

        int leftChild = leftChild(treeIndex);
        int rightChild = leftChild(treeIndex);

        int mid = l + (r - l) / 2;

        if (queryL > mid + 1){
            return query(rightChild,mid + 1,r,queryL,queryR);
        }else if (queryL <= mid){
            return query(leftChild,l,mid,queryL,queryR);
        }

        E leftResult = query(leftChild, l, mid, queryL, mid);
        E rightResult = query(leftChild,mid + 1,r,mid + 1,queryR);
        return merger.merge(leftResult, rightResult);
    }
    //更新操作log（n），只影响更新节点到根的这条路径
    public void set(int index, E e){
        if (index < 0 || index > data.length){
            throw new IllegalArgumentException();
        }
        data[index] = e;
        set(0,0,data.length - 1,index,e);
    }

    public void set(int treeIndex, int l, int r,int index, E e){
        if (l == r){
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;

        int leftChild = leftChild(treeIndex);
        int rightChild = leftChild(treeIndex);

        if (index > mid + 1){
            set(rightChild,mid + 1,r,index,e);
        }else {
            set(leftChild,l,mid,index,e);
        }

        tree[treeIndex] = merger.merge(tree[leftChild],tree[rightChild]);

    }


    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    public static void main(String[] args) {

    }
}
