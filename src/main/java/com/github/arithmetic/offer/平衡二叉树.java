package com.github.arithmetic.offer;

/**
 *
 * 平衡二叉树
 * 时间限制：1秒 空间限制：32768K 热度指数：184594
 *  算法知识视频讲解
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/6 16:31
 */
public class 平衡二叉树 {


    public boolean IsBalanced_Solution(TreeNode root) {
        return getTreeDepth(root) != -1;
    }

    private int getTreeDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftTreeDepth = getTreeDepth(root.left);
        if (leftTreeDepth == -1){
            return -1;
        }
        int rightTreeDepth = getTreeDepth(root.right);
        if (rightTreeDepth == -1){
            return -1;
        }

        return Math.abs(leftTreeDepth - rightTreeDepth) > 1 ? -1 : 1 + Math.max(leftTreeDepth, rightTreeDepth);
    }



    /** 最容易想的思路：递归求每个节点树高度，然后判断平衡性*/
    public boolean IsBalanced_Solution2(TreeNode root) {
        if (root == null){
            return true;
        }
        //左子树和右子树高度差值大于1，则不是平衡树
        if (Math.abs(getTreeHight(root.left) - getTreeHight(root.right)) > 1){
            return false;
        }
        //左右子树是否平衡
        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int getTreeHight(TreeNode root){
        if (root == null){
            return 0;
        }

        return Math.max(getTreeHight(root.left),getTreeHight(root.right)) + 1;
    }
}
