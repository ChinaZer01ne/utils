package com.github.arithmetic.offer;

/**
 *
 * 二叉树的镜像
 * 时间限制：1秒 空间限制：32768K 热度指数：257066
 *  算法知识视频讲解
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 * 输入描述:
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 *
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/6 11:56
 */
public class 二叉树的镜像 {


    /** 思路：递归，对每个子树进行镜像*/
    public void Mirror(TreeNode root) {
        if (root == null){
            return;
        }

        if (root.left == null && root.right == null){
            return;
        }else {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }

        Mirror(root.left);
        Mirror(root.right);

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
