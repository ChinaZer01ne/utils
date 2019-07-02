package com.github.arithmetic.structure;

public class MyPriorityQueue<E extends Comparable<E>> implements MyQueue<E> {


    private MaxHeap<E> heap;

    public MyPriorityQueue(){
        heap = new MaxHeap<>();
    }


    @Override
    public int getSize() {
        return heap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public E dequeue() {

        return heap.extractMax();
    }

    @Override
    public void enqueue(E e) {
        heap.add(e);
    }

    @Override
    public E getFront() {
        return heap.findMax();
    }
}
