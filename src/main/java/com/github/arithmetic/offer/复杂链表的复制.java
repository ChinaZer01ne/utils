package com.github.arithmetic.offer;

import java.util.HashMap;

/**
 * 复杂链表的复制
 * 时间限制：1秒 空间限制：32768K 热度指数：348751
 * 本题知识点： 链表
 *  算法知识视频讲解
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author Zer01ne
 * @since 2019/5/10 21:08
 */
public class 复杂链表的复制 {

    public static void main(String[] args) {
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node1.random = node3;
        node2.random = null;
        node3.random = node5;
        node4.random = node1;
        node5.random = null;

        RandomListNode node = Clone3(node1);

        while (node != null){
            System.out.println(node.label);
            if (node.random != null){
                System.out.println(node.random.label);
            }else {
                System.out.println("null");
            }
            node = node.next;
        }


    }
    /** 思路：先遍历列表保存对应关系，然后复制random，然后拆分
     *  为什么复制random和复制next不放一块，因为在复制next的时候，映射关系就被打乱了
     * */
    public static RandomListNode Clone3(RandomListNode pHead) {

        if (pHead == null){
            return pHead;
        }
        RandomListNode tHead = pHead;
        RandomListNode nHead = pHead;
        RandomListNode rHead = pHead;

        //建立对应关系
        while (tHead != null){
            RandomListNode node = new RandomListNode(tHead.label * 10);
            node.next = tHead.next;
            tHead.next = node;
            tHead = node.next;
        }

        //复制random指针
        while (nHead != null){
            RandomListNode copyNode = nHead.next;
            if (nHead.random != null){
                copyNode.random = nHead.random.next;
            }
            if (nHead.next != null){
                nHead = nHead.next.next;
            }else {
                nHead = nHead.next;
            }
        }

        RandomListNode result = pHead.next;

        //复制next指针，还原原链表
        while (rHead != null){
            RandomListNode nextNode = rHead.next;
            rHead.next = nextNode.next;
            if (nextNode.next != null){
                nextNode.next = nextNode.next.next;
            }
            rHead = rHead.next;
        }
        return result;
    }


    /** 思路：先遍历列表保存对应关系存到map，然后*/
    public static RandomListNode Clone(RandomListNode pHead) {

        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();

        RandomListNode tHead = pHead;
        RandomListNode nHead = pHead;

        while (tHead != null){
            map.put(tHead,new RandomListNode(tHead.label));
            tHead = tHead.next;
        }

        while (nHead != null){
            RandomListNode node = map.get(nHead);
            node.next = map.get(nHead.next);
            node.random = map.get(nHead.random);
            nHead = nHead.next;
        }

        return map.get(pHead);
    }

    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
}
