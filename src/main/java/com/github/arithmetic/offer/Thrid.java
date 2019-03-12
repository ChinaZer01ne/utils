package com.github.arithmetic.offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 【第三题】
 *
 * 从头到尾打印链表
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：759827
 * 本题知识点： 链表
 *
 * 题目描述
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 *
 * 因为要逆序，我第一反应是递归或栈
 *
 * @author Zer01ne
 * @since 2019/3/12 21:48
 */
public class Thrid {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        //return byStack(listNode);
        ArrayList<Integer> list = new ArrayList<>();

        //递归的性质实现反转
        recursion(list,listNode);
        return list;
    }
    /**
     * 递归的方式
     */
    private void recursion(ArrayList<Integer> list,ListNode listNode) {

        if (listNode == null){
            return;
        }
        //直到最后一层返回
        recursion(list,listNode.next);
        //add 这一层保存的节点
        list.add(listNode.val);
    }
    /**
     * 栈的方式
     */
    private ArrayList<Integer> byStack(ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        while (listNode != null){
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!stack.isEmpty()){
            arrayList.add(stack.pop());
        }

        return arrayList;
    }
}

class ListNode {
    public int val;
    public ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}
