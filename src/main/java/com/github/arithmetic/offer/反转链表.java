package com.github.arithmetic.offer;

import java.util.Stack;

/**
 * 【第15题】 反转链表
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：417477
 * 本题知识点： 链表
 *
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 *
 * @author Zer01ne
 * @since 2019/3/14 22:13
 */
public class 反转链表 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        ListNode head = ReverseList(node1);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    /**
     * 思路1：反转？栈呗
     * 思路2：反转？递归啊
     */

    private static ListNode newNode = null;
    public static ListNode ReverseList(ListNode head) {
        ListNode process = process(head);
        if (process == null){
            return null;
        }
        process.next = null;
        return newNode;
    }
    private static ListNode process(ListNode head){
        if (head == null){
            return null;
        }

        ListNode node = process(head.next);

        if (node != null){
            node.next = head;
        }else {
            //当是null的时候刚好是为节点，保存为头节点
            newNode = head;
        }

        return head;
    }
    public static ListNode ReverseList2(ListNode head) {

        if (head == null){
            return null;
        }

        Stack<ListNode> stack = new Stack<>();

        while (head != null){
            stack.push(head);
            head = head.next;
        }

        ListNode newHead = stack.pop();
        ListNode tempNode = newHead;

        while (!stack.isEmpty()){
            tempNode.next = stack.pop();
            tempNode = tempNode.next;
        }
        //反转过后，头节点next指针置为null
        tempNode.next = null;

        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
