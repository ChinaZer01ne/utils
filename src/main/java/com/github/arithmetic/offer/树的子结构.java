package com.github.arithmetic.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 【第17题】 树的子结构
 * 时间限制：1秒 空间限制：32768K 热度指数：401243
 *  算法知识视频讲解
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * @author Zer01ne
 * @since 2019/3/14 23:15
 */
public class 树的子结构 {

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;

        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(2);
        node6.left = node7;

        System.out.println(HasSubtree(node1, node6));
    }

    /** 思路：遍历A树，对于A树的每一个节点进行验证是不是B树结构*/
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {

        //如果都为null，直接返回false
        if (root1 == null || root2 == null){
            return false;
        }

        //利用层级遍历对每一个节点进行比较
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);

        while (!queue.isEmpty()){

            TreeNode node = queue.poll();

            if (treeEquals(node,root2)){
                return true;
            }

            if (node == null){
                continue;
            }
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }

        return false;
    }

    private static boolean treeEquals(TreeNode root1,TreeNode root2){
        //如果B树为走到头了，返回true
        if (root2 == null){
            return true;
            //如果A树走到头了，还没匹配到，返回false
        }else if (root1 == null){
            return false;
            //匹配：当前结果 && 左子树匹配结果 && 右子树匹配结果
        }else {

            return root1.val == root2.val && treeEquals(root1.left,root2.left) && treeEquals(root1.right,root2.right);

        }
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

