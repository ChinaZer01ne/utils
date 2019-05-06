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
     *      1、如果当前节点是左树父节点的左子树，那么在中序遍历中下一个节点就是父节点
     *      2、如果当前节点是右树父节点的左子树，那么在中序遍历中下一个节点就是父节点
     *
     *      3、如果当前节点是左树父节点的右子树，那么在中序遍历中下一个节点就是父节点的父节点
     *      4、如果当前节点是右树父节点的右子树，那么在中序遍历中下一个节点就是右子树节点
     *
     *      5、如果当前节点是根节点，那么在中序遍历中下一个节点就是右子树节点
     *      */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {

        TreeLinkNode parent = pNode.next;
        TreeLinkNode temp = pNode;

        //5
        if (parent == null){
            return pNode.right;
        }

        //1，2
        if (parent.left == pNode){
            return parent;
        }

        //判断当前节点是在左树还是右树
        while (parent != null){
            if (parent.right != temp){
                return pNode.next.next;
            }
            parent = parent.next;
            temp = temp.next;
        }

        return pNode.right;
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
