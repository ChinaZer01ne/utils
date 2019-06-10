package com.github.arithmetic.offer;

import com.alibaba.druid.sql.visitor.functions.Lpad;
import com.github.arithmetic.FindFirstIntersectNode;

/**
 *
 * 两个链表的第一个公共结点 TODO
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：183440
 * 本题知识点： 链表
 *  算法知识视频讲解
 * 题目描述
 *
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * @author Zer01ne
 * @since 2019/3/27 21:06
 */
public class 两个链表的第一个公共结点 {


    /** 思路：
     *      要想求两个链表的第一个公共节点，首先应该判断两个链表是否相交，
     *          不相交：不存在公共节点
     *          相交：
     *              如果两条链表相交，又可以分为有环链表相交问题和无环链表相交问题
     *                  无环：Y字型
     *                  有环：
     *                      环在末尾
     *                      环在中间
     * */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null){
            return null;
        }
        ListNode loopNode1 = getLoopNode(pHead1);
        ListNode loopNode2 = getLoopNode(pHead2);

        //两个链表无环
        if (loopNode1 == null && loopNode2 == null){
            return noLoop(pHead1,pHead2);
        }

        //两个链表有环
        if (loopNode1 != null && loopNode2 != null){
            return bothLoop(pHead1, loopNode1, pHead2,loopNode2);
        }

        return null;
    }

    /**
     * 有环链表相交问题
     */
    private ListNode bothLoop(ListNode pHead1, ListNode loopNode1, ListNode pHead2, ListNode loopNode2) {

        if (loopNode1 == loopNode2){
            //回到无环链表相交问题，只不过终点是loopNode1，loopNode2
            ListNode cur1 = null;
            ListNode cur2 = null;
            cur1 = pHead1;
            cur2 = pHead2;
            int n = 0;
            while (cur1 != loopNode1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loopNode2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? pHead1 : pHead2;
            cur2 = cur1 == pHead1 ? pHead2 : pHead1;
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
            ListNode cur = loopNode1.next;

            while (cur != loopNode1){
                if (cur == loopNode2){
                    return loopNode1;

                }
                cur = cur.next;
            }
        }

        return null;
    }

    /**
     * 无环链表相交问题
     */
    private ListNode noLoop(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        int length1 = 0;
        int length2 = 0;
        ListNode temp1 = pHead1;
        ListNode temp2 = pHead2;
        while (temp1 != null){
            length1++;
            temp1 = temp1.next;
        }
        while (temp2 != null){
            length2++;
            temp2 = temp2.next;
        }

        temp1 = pHead1;
        temp2 = pHead2;



        int length = Math.abs(length1 - length2);

        while (length != 0){

            if (length1 > length2){
                temp1 = temp1.next;
            }else {
                temp2 = temp2.next;
            }


            length--;
        }


        while (temp1 == temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }

    /**
     * 返回第一个入环节点
     *
     * 思路：
     *      第一种方法：哈希表
     *      第二种方法：快慢指针
     *
     */
    private ListNode getLoopNode(ListNode head){

        ListNode fast = head;
        ListNode slow = head;
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






    public static void main(String[] args) {

    }



    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }




}
