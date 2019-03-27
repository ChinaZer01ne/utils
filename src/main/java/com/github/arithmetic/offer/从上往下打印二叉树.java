package com.github.arithmetic.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 从上往下打印二叉树
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：312070
 *  算法知识视频讲解
 *
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @Author: Zer01ne
 * @Date: 2019/3/27 15:46
 * @Version 1.0
 */
public class 从上往下打印二叉树 {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> list = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if (node != null){
                list.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return list;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(16);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.left = node7;

        PrintFromTopToBottom(root);
    }
}
