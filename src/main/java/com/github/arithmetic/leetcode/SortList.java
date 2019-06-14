package com.github.arithmetic.leetcode;

/**
 * sort-list
 * 时间限制：1秒 空间限制：32768K 热度指数：56064
 * 本题知识点： 排序 链表 leetcode
 *  算法知识视频讲解
 * 题目描述
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/14 14:19
 */
public class SortList {

    /**
     * 排序：
     *      时间复杂度 O(n log n)
     *      空间复杂度 O(1)
     *
     * 思路:
     *      时间复杂度 O(n log n)的排序有归并，堆，快排
     *
     * */
    public ListNode sortList(ListNode head) {
        return null;
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
             val = x;
             next = null;
        }
    }
}
