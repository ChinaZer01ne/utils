package com.github.arithmetic.offer;

/**
 * 二叉树的下一个结点
 * 时间限制：1秒 空间限制：32768K 热度指数：158154
 *  算法知识视频讲解
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 * @author Zer01ne
 * @since 2019/5/6 20:03
 */
public class 二叉树中下一个节点 {

    /** 思路：
     *      分析二叉树的下一个节点，一共有以下情况：
     *          1.二叉树为空，则返回空；
     *          2.节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
     *          3.节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。
     *      */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        if (pNode == null){
            return null;
        }

        if (pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }

        while (pNode.next != null){
            if (pNode == pNode.next.left){
                return pNode.next;
            }else {

                pNode = pNode.next;
            }
        }


        return null;
    }


    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

}
