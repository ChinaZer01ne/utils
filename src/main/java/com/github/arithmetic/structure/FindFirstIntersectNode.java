package com.github.arithmetic.structure;

import com.github.arithmetic.offer.两个链表的第一个公共结点;

import java.util.HashSet;

/**
 * 判断单链表是否相交，如果相交，返回第一个相交节点
 * @Author: Zer01ne
 * @Date: 2019/1/21 11:53
 * @Version 1.0
 */
public class FindFirstIntersectNode {

    static class Node<T>{
        T data;
        Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

    }

    public static void main(String[] args) {
        Node node1 = new Node(1,null);
        Node node2 = new Node(2,node1);
        Node node3 = new Node(3,node2);
        Node node4 = new Node(4,node3);
        Node node5 = new Node(5,node4);
        Node node6 = new Node(6,node5);
        //node1.next = node3;
        //System.out.println(getLoopNode(node6).data);
        Node node7 = new Node(1,null);
        Node node8 = new Node(2,node7);
        Node node9 = new Node(3,node8);
        Node node0 = new Node(4,node9);
        Node node01 = new Node(5,node0);
        Node node02 = new Node(6,node01);
        System.out.println(getIntersectNode(node02,node6).data);
    }

    private static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        //两个链表都无环
        if (loop1 == null && loop2 == null){
            return noLoop(head1, head2);
        }
        //两个链表都有环
        if (loop1 != null && loop2 != null){
            return bothLoop(head1, loop1, head2,loop2);
        }
        //一个有环一个无环，单链表不可能相交
        return null;
    }

    //两个有环链表相交问题，三种情况，1，不相交，2，相交最后带个环（Y形状最后带个环）3，共同组成环
    private static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        //如果入环节点相同，说明是第二种情况,与无环相交问题是一样的
        if (loop1 == loop2){
            //回到无环链表相交问题，只不过终点是loopNode1，loopNode2
            Node cur1 = null;
            Node cur2 = null;
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            Node cur = loop1.next;
            //当loop1和cur相等的时候，说明转了一圈没有找到loop2，不相交，如果找到loop2，说明相交
            while (cur != loop1){
                if (cur == loop2){
                    return loop1;
                }
                cur = cur.next;
            }
        }
        return null;
    }

    //两个无环链表相交问题,一种形式（Y的形状）
    private static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node first = head1;
        Node second = head2;
        int firstLength = 0;
        int secondLength = 0;
        //分别计算出两个链表的长度
        while (first != null){
            firstLength++;
            first = first.next;
        }
        while (second != null){
            secondLength++;
            second = second.next;
        }
        first = head1;
        second = head2;

        int length = Math.abs(firstLength - secondLength);

        //两个链表从距离交点相同位置处开始移动
        while (length != 0){
            if (firstLength > secondLength){
                first = first.next;
            }else {
                second = second.next;
            }
            length--;
        }
        //如果有相等节点，则说明相交
        while (first != second){
            first = first.next;
            second = second.next;
        }

        return first;
    }

    //返回第一个入环节点，哈希表的方式
    private static Node getLoopNode(Node head){
        HashSet set = new HashSet();
        Node cur = head;
        while (cur != null){
            if (!set.add(cur)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //返回第一个入环节点，不用哈希表的方式
    private static Node hasLoopWithoutHash(Node head){
        Node fast = head;
        Node slow = head;
        boolean equals = false;

        while (fast != null && slow != null){


            if (fast.next != null && !equals){
                fast = fast.next.next;
            }else {
                fast = fast.next;
            }

            slow = slow.next;

            if (fast == slow){
                if (equals){
                    return fast;
                }
                fast = head;
                if (head == slow){
                    return head;
                }
                equals = true;
            }

        }
        return null;
    }
    //返回第一个入环节点，不用哈希表的方式
    public static Node hasLoopWithoutHash2(Node head) {
        if (head == null || head.next == null || head.next.next == null){
            return null;
        }
        Node fast = head.next;
        Node slow = head.next;
        while (fast != slow){
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        while (fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
