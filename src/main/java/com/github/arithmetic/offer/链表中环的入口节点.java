package com.github.arithmetic.offer;

/**
 *
 * 链表中环的入口结点
 * 时间限制：1秒 空间限制：32768K 热度指数：187146
 * 本题知识点： 链表
 *  算法知识视频讲解
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/11 17:14
 */
public class 链表中环的入口节点 {

    public static void main(String[] args) {

    }
    /**
     * 链表相交的第一个节点问题的先前步骤
     *
     * 方法一：哈希表
     * 方法二：快慢指针
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {

        if (pHead== null || pHead.next == null || pHead.next.next == null){
            return null;
        }

        ListNode first = pHead;
        ListNode second = pHead;

        while (first != null){
            if (first.next != null){
                first = first.next.next;
            }else {
                first = null;
            }

            second = second.next;

            if (first == second){
                first = pHead;

                while (first != second){
                    first = first.next;
                    second = second.next;
                }

                return first;
            }



        }

        return null;
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
