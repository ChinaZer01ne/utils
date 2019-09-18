package com.github.arithmetic.leetcode;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/9/18 12:51
 */
public class ReverseList {


    // 1、用栈的话很容易实现
    // 2、用迭代
    // 3、递归
    public ListNode reverseList(ListNode head) {

        if(head == null){
            return null;
        }

        ListNode prev = null;
        ListNode cur = head;

        while(cur != null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }

    public ListNode reverseListByRec(ListNode head) {


        if (head == null || head.next == null){
            return head;
        }

        ListNode p = reverseListByRec(head.next);
        head.next.next = head;
        head.next = null;
        return p;

    }

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public static void main(String[] args) {

    }
}
