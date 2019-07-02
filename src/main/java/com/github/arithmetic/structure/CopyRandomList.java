package com.github.arithmetic.structure;

import java.util.HashMap;

/**
 * 一个链表除了next指针还有一个random指针，拷贝这个链表
 * @Author: Zer01ne
 * @Date: 2019/1/21 10:00
 * @Version 1.0
 */
public class CopyRandomList {

    static class Node<T>{
        T data;
        Node<T> next;
        Node<T> random;

        Node(T data, Node<T> next, Node<T> random) {
            this.data = data;
            this.next = next;
            this.random = random;
        }

    }

    public static void main(String[] args) {
        Node node1 = new Node(1,null,null);
        Node node2 = new Node(2,node1,node1);
        Node node3 = new Node(3,node2,null);
        Node node4 = new Node(4,node3,node1);
        Node node5 = new Node(5,node4,node2);
        printLink(node5);
        System.out.println("========================");
        //Node head = copy(node5);
        Node head = copyLink(node5);
        printLink(head);

    }

    private static void printLink(Node head) {
        while (head != null){
            System.out.print(head.data + "\t");
            if (head.random != null){
                System.out.print(head.random.data);
            }
            System.out.println();
            head = head.next;

        }
    }
    //使用额外空间（哈希表）的方式
    private static Node copy(Node head){
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        //将原链表的每个节点映射
        while (cur != null){
            map.put(cur,new Node(cur.data,null,null));
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random =  map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
    //不适用哈希表的方式
    private static Node copyLink(Node head){
        Node cur = head;
        while (cur != null){
            cur.next = new  Node(cur.data,cur.next,null);
            cur = cur.next.next;
        }
        cur = head;
        Node newNode = head.next;
        while (cur != null){
            if (cur.next != null){
                Node temp = cur.next;
                cur.next = temp.next;
                temp.next = temp.next == null ? null: temp.next;
                temp.random = cur.random == null ? null : cur.random.next;
                cur = cur.next;
            }else {
                cur = cur.next;
            }

        }
        return newNode;
    }
}
