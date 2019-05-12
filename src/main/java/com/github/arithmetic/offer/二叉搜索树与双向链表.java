package com.github.arithmetic.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 二叉搜索树与双向链表
 * 时间限制：1秒 空间限制：32768K 热度指数：245788
 *  算法知识视频讲解
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 *
 * @author Zer01ne
 * @since 2019/5/11 20:49
 */
public class 二叉搜索树与双向链表 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(10);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        TreeNode convert = Convert(root);
        while (convert != null){
            System.out.println(convert.val);
            convert = convert.right;
        }
    }
    /** 思路：中序遍历的同时组装链表*/
    public static TreeNode Convert2(TreeNode pRootOfTree) {
        return null;
    }
    /** 思路：中序遍历保存节点，然后进行组装*/
    public static TreeNode Convert(TreeNode pRootOfTree) {



        Queue<TreeNode> storeQueue = new LinkedList<>();

        walkTree(storeQueue,pRootOfTree);

        TreeNode root = storeQueue.peek();
        TreeNode tempNode = storeQueue.poll();

        if (root == null){
            return null;
        }

        while (!storeQueue.isEmpty()){

            TreeNode node = storeQueue.poll();
            //原节点右子树指针指向前一个节点
            node.left = tempNode;
            //上一次节点左子树指向下一个节点
            tempNode.right = node;

            tempNode = node;
        }

        tempNode.right = null;
        return root;
    }

    private static void walkTree(Queue<TreeNode> queue, TreeNode pRootOfTree){
        if (pRootOfTree == null){
            return;
        }
        walkTree(queue,pRootOfTree.left);
        queue.add(pRootOfTree);
        walkTree(queue,pRootOfTree.right);
    }
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
