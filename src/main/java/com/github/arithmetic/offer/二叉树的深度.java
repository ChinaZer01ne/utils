package com.github.arithmetic.offer;

/**
 *
 * 二叉树的深度
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：137580
 *  算法知识视频讲解
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 *
 *
 * @author Zer01ne
 * @since 2019/3/26 21:43
 */
public class 二叉树的深度 {

    public static void main(String[] args) {

    }

    public int TreeDepth(TreeNode root) {

        if (root == null){
            return 0;
        }

        int leftHeight = TreeDepth(root.left) + 1;
        int rightHeight = TreeDepth(root.right) + 1;

        return Math.max(leftHeight,rightHeight);
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
}
