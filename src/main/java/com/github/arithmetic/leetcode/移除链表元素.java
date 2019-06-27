package com.github.arithmetic.leetcode;

/**
 * 删除链表中等于给定值 val 的所有节点。
 *
 * 示例:
 *
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/27 10:49
 */
public class 移除链表元素 {


    /**
     * 采用头节点
     * @param head :
     * @param val :
     * @return com.github.arithmetic.leetcode.移除链表元素.ListNode
     * @throws
     */
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        while (prev.next != null){
            if (prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }


    /**
     * 不采用头节点
     * @param head :
     * @param val :
     * @return com.github.arithmetic.leetcode.移除链表元素.ListNode
     * @throws
     */
    public ListNode removeElements2(ListNode head, int val) {

        //开头元素相等的情况
        while (head != null && head.val == val){
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null){
            return null;
        }

        ListNode prev = head;

        while (prev.next != null){
            if (prev.next.val == val){
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else {
                prev = prev.next;
            }
        }


        return head;
    }


    /**
     * 递归
     * @param head :
     * @param val :
     * @return com.github.arithmetic.leetcode.移除链表元素.ListNode
     * @throws
     */
    public ListNode removeElements3(ListNode head, int val) {
        if (head == null){
            return null;
        }
        //if (head.val == val){
        //    return removeElements3(head.next,val);
        //}else {
        //    head.next = removeElements3(head.next,val);
        //    return head;
        //}

        head.next = removeElements3(head.next,val);
        return head.val == val ? head.next : head;
    }


     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

}
