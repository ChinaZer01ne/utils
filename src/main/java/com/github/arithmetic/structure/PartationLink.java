package com.github.arithmetic.structure;

/**
 * 在链表结构中，小于区域放左边，等于区域在中间，大于区域在右边
 * @Author: Zer01ne
 * @Date: 2019/1/18 10:36
 * @Version 1.0
 */
public class PartationLink<T> {

    static class Node<T>{
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

    }

    private Node<T> head = new Node<>(null,null);
    private Node cur = head;

    PartationLink.Node add(T e){
        cur.next = new Node<>(e,null);
        cur = cur.next;
        return head;
    }

    public static void main(String[] args) {
        PartationLink<Integer> partationLink = new PartationLink<>();
        partationLink.add(6);
        partationLink.add(2);
        partationLink.add(5);
        partationLink.add(3);
        partationLink.add(7);

        Node<Integer> head = partation(partationLink.head, 1);

        Node<Integer> cur = head.next;
        while (cur != null){
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    //做到稳定性的方法
    //分别记录小于num，等于num，大于num的值，按顺序组成链表（保证了稳定性），最后串联起来
    private static Node<Integer> partation(Node<Integer> head,int num){

        int less = 0;
        int equals = 0;
        int more = 0;
        PartationLink<Integer> lessGroup = new PartationLink<>();
        PartationLink<Integer> equalsGroup = new PartationLink<>();
        PartationLink<Integer> moreGroup = new PartationLink<>();

        Node<Integer> cur = head.next;

        while (cur != null){
            if (cur.data < num){
                less = cur.data;
                lessGroup.add(less);
            }else if (cur.data == num){
                equals = cur.data;
                equalsGroup.add(equals);

            }else {
                more = cur.data;
                moreGroup.add(more);

            }
            cur = cur.next;
        }
        //将小于区域，等于区域，大于区域，依次连接起来
        if (equalsGroup.head.next == null){
            lessGroup.cur.next = moreGroup.head.next;

        }else {
            lessGroup.cur.next = equalsGroup.head.next;
            equalsGroup.cur.next = moreGroup.head.next;
        }

        return lessGroup.head;
    }


    //将链表转换为数组，就变成了荷兰国旗问题(做不到稳定性)
    private static void partation2(){

    }
}
