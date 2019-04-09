package com.github.arithmetic.leetcode;
/**
 * 求最大树深
 *
 * maximum-depth-of-binary-tree
 * 时间限制：1秒 空间限制：32768K 热度指数：14836
 * 本题知识点： 树 leetcode
 *  算法知识视频讲解
 * 题目描述
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * @author Zer01ne
 * @since 2019/4/9 22:02
 */
public class MaxTreeDepth {

    public static void main(String[] args) {

    }
    /**
     * 思路：左右子树最深的高度 + 1
     * */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
