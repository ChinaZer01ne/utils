package com.github.arithmetic.leetcode;
/**
 * 最小树深
 *
 * minimum-depth-of-binary-tree
 * 时间限制：1秒 空间限制：32768K 热度指数：104748
 * 本题知识点： 树
 *  算法知识视频讲解
 * 题目描述
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * 最小深度是从根节点到最近的叶节点沿最短路径的节点数。
 *
 * @author Zer01ne
 * @since 2019/4/9 22:14
 */
public class MinTreeDepth {
    public static void main(String[] args) {

    }

    /**
     * 思路：深度优先遍历，效率低
     * 如果左子树为空，就找右子树
     * 如果右子树为空，就找左子树
     * 如果左右子树都不为空，就找左右子树较小的深度
     */
    public int minDepth(TreeNode root) {

        if (root == null){
            return 0;
        }
        if (root.left == null){
            return minDepth(root.right) + 1;
        }else if (root.right == null){
            return minDepth(root.left) + 1;
        }else {
            int leftDepth = minDepth(root.left);
            int rightDepth = minDepth(root.right);
            return leftDepth < rightDepth ? leftDepth + 1 : rightDepth + 1;
        }
    }

    /**
     * 思路：广度优先遍历
     */
    public int minDepth2(TreeNode root) {
        return 0;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
