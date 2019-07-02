package com.github.arithmetic.structure;

public class MaxHeap<E extends Comparable<E>> {

    private MyArrayList<E> data;

    public MaxHeap(){
        data = new MyArrayList<>();
    }
    public MaxHeap(E[] arr){
        data = new MyArrayList<>(arr);
    }

    public MaxHeap(int capacity){
        data = new MyArrayList<>(capacity);
    }

    public int getSize(){
        return data.size();
    }

    public int getCapacity(){
        return data.capacity();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    private int parent(int index){
        if (index < 0 || index > data.size()){
            throw new IllegalArgumentException();
        }

        return (index - 1) / 2;
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    public void add(E e){
        data.add(e);
        siftUp(getSize() - 1);

    }

    private void siftUp(int index) {
        while (data.get(parent(index)).compareTo(data.get(index)) < 0){
            int parent = parent(index);
            data.swap(index,parent);
            index = parent;
        }
    }

    public E findMax(){
        if (data.size() == 0){
            throw new IllegalArgumentException();
        }
        return data.get(0);
    }

    public E extractMax(){

        E max = findMax();

        data.swap(0,data.size() - 1);

        data.removeLast();

        siftDown(0);

        return max;

    }

    public E replace(E e){

        E res = findMax();

        data.set(0,e);

        siftUp(0);

        return res;
    }


    public void heapify(E[] arr){
        //最后一个非叶子节点
        int lastNotLeaf = parent(arr.length - 1);
        for (int i = lastNotLeaf; i >= 0; i--) {
            siftDown(i);
        }
    }

    private void siftDown(int index) {

        while (leftChild(index) < getSize()){
            int j = leftChild(index);
            if (j + 1 < getSize()
                            && data.get(j).compareTo(data.get(j + 1)) < 0){
                j = rightChild(index);
            }
            //此时data[j]是左右两个孩子最大值
            if (data.get(j).compareTo(data.get(index)) > 0){
                data.swap(j,index);
                index = j;
            }else {
                break;
            }
        }

    }

}
