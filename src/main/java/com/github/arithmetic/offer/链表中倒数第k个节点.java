package com.github.arithmetic.offer;

/**
 * 【第14题】 链表中倒数第k个节点
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：574691
 * 本题知识点： 链表
 *
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点
 *
 * @author Zer01ne
 * @since 2019/3/14 21:36
 */
public class 链表中倒数第k个节点 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node5.next = node5;
        System.out.println(FindKthToTail(node1, 3).val);
    }
    /**
     * 思路：1、先遍历链表求出长度length，然后从头开始走length-k步
     * 思路：2、递归的思想
     * 思路：3、用两个指针，p1，p2，p1先走k-1步，然后共同走，p1到最后，p2就是倒数k位置
     */
    private static int count = 0;
    private static ListNode targetNode = null;
    public static ListNode FindKthToTail(ListNode head,int k) {

        if (head == null){
            return null;
        }

        ListNode node = FindKthToTail(head.next,k);
        //这一步保证了找到节点，就一直返回该节点
        if(node != null){
            return node;
        }

        count++;

        if (count == k){
            //targetNode = head;
            return head;
        }
        //return targetNode;
        return null;
    }


    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}

