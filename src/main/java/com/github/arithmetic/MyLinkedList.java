package com.github.arithmetic;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/26 17:06
 */
public class MyLinkedList {


    private Node head;
    private int size;

    public MyLinkedList() {
        head = null;
        size = 0;
    }


    public void add(T t){
        t = new Node(t);
    }









    private class Node{
        public T t;
        private Node next;

        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }

        public Node(T t) {
            this.t = t;
        }

        public Node() {
        }

        @Override
        public String toString() {
            return t.toString();
        }
    }
}
