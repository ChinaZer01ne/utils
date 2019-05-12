package com.github.arithmetic.offer;

/**
 *
 * 二叉搜索树的第k个结点
 * 时间限制：1秒 空间限制：32768K 热度指数：197192
 *  算法知识视频讲解
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 *
 * @author Zer01ne
 * @since 2019/5/12 17:01
 */
public class 二叉搜索树的第k个节点 {

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

        System.out.println(KthNode(root, 3).val);
    }

    static int count = 0;


    /** 思路：中序遍历第k个值*/
    static TreeNode KthNode(TreeNode pRoot, int k) {


        if (pRoot == null){

            return null;
        }

        TreeNode node = KthNode(pRoot.left, k);

        if (node != null){
            return node;
        }
        if (++count == k){
            return pRoot;
        }


        node = KthNode(pRoot.right,k);
        if (node != null){
            return node;
        }
        return null;

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
