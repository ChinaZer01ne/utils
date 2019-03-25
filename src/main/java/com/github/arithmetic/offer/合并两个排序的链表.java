package com.github.arithmetic.offer;

/**
 * 【第16题】
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：415353
 * 本题知识点： 链表
 *  算法知识视频讲解
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 *
 * @Author: Zer01ne
 * @Date: 2019/3/25 16:45
 * @Version 1.0
 */
public class 合并两个排序的链表 {

    public static void main(String[] args) {

    }

    /**
     * 思路：我的第一想法是外排的方式，类似归并中的外排，用了额外的空间 O(M+N)
     */
    public ListNode Merge(ListNode list1,ListNode list2) {


        //链表1的临时头节点
        ListNode listHead1 = list1;
        //链表2的临时头节点
        ListNode listHead2 = list2;

        ListNode newHead = new ListNode(0);
        ListNode tempHead = newHead;

        //类似归并的外排的方式
        while (listHead1 != null && listHead2 != null){
            if (listHead1.val > listHead2.val){
                tempHead.next = new ListNode(listHead2.val);
                tempHead = tempHead.next;
                listHead2 = listHead2.next;
            }else {
                tempHead.next = new ListNode(listHead1.val);
                tempHead = tempHead.next;
                listHead1 = listHead1.next;
            }
        }

        if (listHead1 != null){
            tempHead.next = listHead1;
        }

        if (listHead2 != null){
            tempHead.next = listHead2;
        }

        return newHead.next;
    }

    /**
     * 不使用额外空间能不能做？
     *
     * 思路：TODO
     */
    public ListNode Merge2(ListNode list1,ListNode list2) {

        //链表1的头节点
        ListNode listHead1 = list1;
        //链表2的头节点
        ListNode listHead2 = list2;

        //链表1的临时节点,记录断开位置
        ListNode listTemp1 = list1;
        //链表2的临时节点,记录断开位置
        ListNode listTemp2 = list2;

        while (listHead1 != null && listHead2 != null){
            if (listHead1.val > listHead2.val){
                listTemp2 = listTemp2.next;
                //tempHead.next = new ListNode(listHead2.val);
                //tempHead = tempHead.next;
                listHead2 = listHead2.next;
            }else {
                //tempHead.next = new ListNode(listHead1.val);
                //tempHead = tempHead.next;
                listHead1 = listHead1.next;
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
