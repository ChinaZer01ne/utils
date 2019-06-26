package com.github.arithmetic;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/26 17:06
 */
public class MyLinkedList<T> {


    private Node<T> dummyHead;
    private int size;

    public MyLinkedList() {
        dummyHead = new Node<>(null,null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(T t){

        //Node node = new Node<>(t);
        //node.next = head;
        //head = node;
        add(0,t);
        size++;

    }

    public void add(int index, T t){
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        Node<T> prev = dummyHead;

        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        //Node node = new Node<>(t);
        //node.next = prev.next;
        //prev.next = node;
        prev.next = new Node<>(t,prev.next);
        size ++;


    }

    public void addLast(T t){
        add(size,t);
    }

    public T get(int index){
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }

        Node<T> cur = dummyHead.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.t;
    }

    public T getFirst() {
        return get(0);
    }

    public T getLast() {
        return get(size - 1);
    }

    public void set(int index,T t) {
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }
        Node<T> cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.t = t;
    }



    public boolean contains(T t){
        Node<T> cur = dummyHead.next;
        for (int i = 0; i < size; i++) {
            if (t != null && t.equals(cur.t)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public T remove(int index){
        if (index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }
        Node<T> prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node<T> cur = prev.next;
        prev.next = cur.next;
        cur.next = null;
        size --;

        return cur.t;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();

        res.append(String.format("size = %d\n",size));
        //Node<T> cur = dummyHead.next;
        //while (cur != null){
        //    res.append(cur);
        //    res.append(" ->");
        //    cur = cur.next;
        //}
        for (Node<T> cur = dummyHead.next;  cur != null; cur = cur.next){
            res.append(cur);
            res.append("->");
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addLast(1);
        System.out.println(list);
        list.addLast(2);
        System.out.println(list);
        list.addLast(3);
        System.out.println(list);
        list.addLast(4);
        System.out.println(list);
        list.addLast(5);
        System.out.println(list);
        System.out.println(list.contains(5));
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
}
