package com.github.arithmetic;

import org.apache.poi.ss.formula.functions.T;

/**
 *
 * 队空和队满的条件
 *
 * 为了区分队空还是堆满的情况，有多种处理方式：
 *
 * 方式1： 牺牲一个单元来区分队空和队满，入队时少用一个队列单元，即约定以"队头指针在队尾指针的下一位置作为队满的标志"。
 * 队满条件为：(rear+1)%QueueSize==front
 * 队空条件为：front==rear
 * 队列长度为：(rear-front++QueueSize)%QueueSize
 *
 * 方式2： 增设表示队列元素个数的数据成员size，此时，队空和队满时都有front==rear。
 * 队满条件为：size==QueueSize
 * 队空条件为：size==0
 *
 * 方式3： 增设tag数据成员以区分队满还是队空
 * tag表示0的情况下，若因删除导致front==rear，则队空；
 * tag等于1的情况，若因插入导致front==rear则队满
 * ---------------------
 * 作者：疯狂1024
 * 来源：CSDN
 * 原文：https://blog.csdn.net/qq_28081081/article/details/80726877
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/26 17:08
 */
public class MyLoopQueue2<T> implements MyQueue<T>{


    private Object[] data;
    private int front;
    private int tail;



    @Override
    public T dequeue() {
        return null;
    }

    @Override
    public void enqueue(T t) {

    }


    @Override
    public int getSize() {
        if (tail - front > 0){
            return tail - front;
        }else {
            return data.length - front + 1 + tail;
        }
    }

    @Override
    public boolean isEmpty() {
        return getSize() == 0;
    }

    @Override
    public T getFront() {
        if (isEmpty()){
            throw new IndexOutOfBoundsException();
        }
        return (T) data[front];
    }

    public int getCapacity() {
        return data.length;
    }
}
