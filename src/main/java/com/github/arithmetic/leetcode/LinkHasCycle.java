package com.github.arithmetic.leetcode;

/**
 *
 * linked-list-cycle
 * 时间限制：1秒 空间限制：32768K 热度指数：21111
 * 本题知识点： 链表 leetcode
 *  算法知识视频讲解
 * 题目描述
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 *
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/11 17:22
 */
public class LinkHasCycle {



    public class Solution {
        public boolean hasCycle(ListNode head) {

            ListNode slow = head;
            ListNode fast = head;

            while (slow != null && fast != null){
                slow = slow.next;
                fast = fast.next;
                if (fast != null){
                    fast = fast.next;
                }else {
                    return false;
                }
                if (slow == fast){
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {

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
