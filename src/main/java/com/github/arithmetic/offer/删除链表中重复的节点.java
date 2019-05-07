package com.github.arithmetic.offer;

import com.github.web.entity.Person;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 删除链表中重复的结点
 * 时间限制：1秒 空间限制：32768K 热度指数：306448
 * 本题知识点： 链表
 *  算法知识视频讲解
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/7 14:25
 */
public class 删除链表中重复的节点 {

    public static void main(String[] args) {
        ListNode tempHead1 = new ListNode(1);
        ListNode tempHead2 = new ListNode(1);
        ListNode tempHead3 = new ListNode(2);
        ListNode tempHead4 = new ListNode(2);
        ListNode tempHead5 = new ListNode(3);
        ListNode tempHead6 = new ListNode(3);
        ListNode tempHead7 = new ListNode(4);
        ListNode tempHead8 = new ListNode(4);
        tempHead1.next = tempHead2;
        tempHead2.next = tempHead3;
        tempHead3.next = tempHead4;
        tempHead4.next = tempHead5;
        tempHead5.next = tempHead6;
        tempHead6.next = tempHead7;
        tempHead7.next = tempHead8;

        ListNode listNode = deleteDuplication2(tempHead1);

        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }


    public static ListNode deleteDuplication2(ListNode pHead) {

        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        LinkedList<ListNode> queue = new LinkedList<>();


        int curValue = pHead.val;


        boolean hasEle = false;

        while (pHead != null){

            if (pHead.val != curValue){
                queue.add(pHead);
                curValue = pHead.val;
                if (hasEle){
                    queue.pollLast();
                }
            } else {
                pHead = pHead.next;
                hasEle = true;
            }
        }

        ListNode node = queue.poll();
        ListNode head = node;
        while (node != null){
            node.next = queue.peek();
            node = queue.poll();
        }

        return head;
    }














        public static ListNode deleteDuplication(ListNode pHead) {

        if (pHead == null || pHead.next == null){
            return pHead;
        }

        ListNode newHead = pHead;
        //设置头节点
        ListNode tempHead = new ListNode(0);
        tempHead.next = pHead;

        //当前节点
        ListNode curNode = pHead;
        //下一个节点
        ListNode nextNode = pHead.next;
        //去重标志
        boolean removal = false;

        while (curNode != null){
            //如果当前节点和下一个节点不相等，当前节点往下走
            if (curNode.val != nextNode.val){
                //开始去重
                if (removal){

                    tempHead.next = nextNode;
                    curNode = nextNode;
                    nextNode = nextNode.next;
                }else {
                    curNode = curNode.next;
                    nextNode = nextNode.next;
                    tempHead = tempHead.next;
                }

                //如果相等，nextNode往下走
            }else {
                nextNode = nextNode.next;


                if (curNode == pHead){
                    newHead = nextNode;
                    curNode = pHead;
                }else {
                    removal = true;
                }
            }

            if (nextNode == null){
                curNode = null;
            }
        }



        return newHead;
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
