package com.github.arithmetic;


/**
 * 带有尾节点的链表实现队列，入队出队O(1)
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/27 9:50
 */
public class MyLinkedQueue<T>  implements MyQueue<T>{

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
            throw new IndexOutOfBoundsException();
        }
        Node<T> retNode = head;
        head = head.next;
        retNode.next =  null;
        if (head == null){
            tail = null;
        }
        size --;
        return retNode.t;
    }

    @Override
    public void enqueue(T t) {
        if (tail == null){
            tail = new Node<>(t);
            head = tail;
        }else {
            tail.next = new Node<>(t);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public T getFront() {
        if (isEmpty()){
            throw new IllegalArgumentException();
        }
        return head.t;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("head<-");
        for (Node node = head; node != null ; node = node.next) {
            sb.append(node.toString());
            sb.append("<-");
        }
        sb.append("tail");
        return sb.toString();
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;



    public  MyLinkedQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    private class Node<T>{
        public T t;
        private Node<T> next;

        public Node(T t, Node<T> next) {
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

    public static void main(String[] args) {
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }
}
