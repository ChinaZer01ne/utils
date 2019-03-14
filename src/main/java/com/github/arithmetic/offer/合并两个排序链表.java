package com.github.arithmetic.offer;
/**
 * 【第16题】 合并两个排序链表
 * 时间限制：1秒 空间限制：32768K 热度指数：399671
 * 本题知识点： 链表
 *
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * @author Zer01ne
 * @since 2019/3/14 23:15
 */
public class 合并两个排序链表 {

    public static void main(String[] args) {

    }

    /**
     * 思路：我的第一想法是外排的方式
     */
    public ListNode Merge(ListNode list1,ListNode list2) {

        //链表1指针
        int p1 = 0;
        //链表2指针
        int p2 = 0;
        //链表1的临时头节点
        ListNode ListHead1 = null;
        //链表2的临时头节点
        ListNode ListHead2 = null;
        while (list1 != null && list2 != null){
            if (list1.val > list2.val){
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
