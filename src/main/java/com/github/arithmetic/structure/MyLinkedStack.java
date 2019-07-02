package com.github.arithmetic.structure;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/27 9:55
 */
public class MyLinkedStack<T> implements MyStack<T> {

    private MyLinkedList<T> linkedList;
    public MyLinkedStack(){
        linkedList = new MyLinkedList<>();
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.getSize() == 0;
    }

    @Override
    public T pop() {
        return linkedList.removeFirst();
    }

    @Override
    public void push(T t) {
        linkedList.addFirst(t);
    }

    @Override
    public T peek() {
        return linkedList.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack : top [");
        sb.append(linkedList.toString());
        sb.append("] bottom");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyLinkedStack<Integer> stack = new MyLinkedStack<>();
        stack.push(1);
        System.out.println(stack.toString());
        System.out.println(stack.getSize());
        stack.push(2);
        System.out.println(stack.toString());
        System.out.println(stack.getSize());
        stack.push(3);
        System.out.println(stack.toString());
        System.out.println(stack.getSize());
        stack.push(4);
        System.out.println(stack.toString());
        System.out.println(stack.getSize());
        stack.push(5);
        System.out.println(stack.toString());
        System.out.println(stack.getSize());


        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
