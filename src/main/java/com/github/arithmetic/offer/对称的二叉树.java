package com.github.arithmetic.offer;

/**
 *
 * 对称的二叉树
 * 时间限制：1秒 空间限制：32768K 热度指数：151622
 *  算法知识视频讲解
 * 题目描述
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/13 13:44
 */
public class 对称的二叉树 {


    /** 思路：首先根节点以及左右子树，左子树的左子树和右子树的右子树相同
     *      左子树的右子树和右子树的左子树相同，递归
     *
     *  */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null){
            return true;
        }

        return comRoot(pRoot.left, pRoot.right);

    }

    private boolean comRoot(TreeNode left, TreeNode right) {

        if (left == null){
            return right == null;
        }
        if (right == null){
            return false;
        }

        if (left.val != right.val){
            return false;
        }

        return comRoot(left.left, right.right) && comRoot(left.right,right.left);
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
