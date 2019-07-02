package com.github.arithmetic.structure;


/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/26 15:57
 */
public class MyLoopQueue<T>  implements MyQueue<T>{


    private Object[] data;
    private int size;
    int front = 0;
    int tail = 0;

    public MyLoopQueue(){
        this(5);
    }

    public MyLoopQueue(int capacity){
        data = new Object[capacity];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public T dequeue() {
        if (isEmpty()){
            return null;
        }
        if (size == data.length / 2){
            resize(data.length / 2);
        }
        Object res = data[(front++) % data.length];
        size--;
        return (T) res;
    }

    @Override
    public void enqueue(T t) {
        if (size == data.length){
            resize(data.length * 2);
        }
        data[(tail++) % data.length] = t;
        size++;
    }

    private void resize(int capacity) {
        Object[] newArray = new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = data[(front + i) % data.length];
        }
        data = newArray;
        front = 0;
        tail = size;
    }

    /** @noinspection unchecked*/
    @Override
    public T getFront() {
        if (isEmpty()){
            return null;
        }
        return (T) data[size - 1];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue : size = %d, capacity = %d\n",size,data.length));
        sb.append("front [");
        int count = 0;
        for (int i = front; count < size; i++) {
            sb.append(data[i % data.length]);
            if (count != size - 1){
                sb.append(",");
            }
            count++;
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLoopQueue<Integer>  queue = new MyLoopQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(6);
        queue.enqueue(6);
        queue.enqueue(6);
        queue.dequeue();
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
    }
}
