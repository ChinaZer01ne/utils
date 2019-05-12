package com.github.arithmetic.offer;

/**
 *
 * 序列化二叉树
 * 时间限制：1秒 空间限制：32768K 热度指数：169197
 *  算法知识视频讲解
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 *
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/7 10:46
 */
public class 序列化二叉树 {

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

        System.out.println(Serialize(root));

    }

    static String Serialize(TreeNode root) {
        if (root == null){
            return "#!";
        }else {
            return  root.val + "," + Serialize(root.left) +  Serialize(root.right);
        }

    }
    TreeNode Deserialize(String str) {

        String ele = str.substring(1);

        if ("#!".equals(ele)){
            return null;
        }else {
            TreeNode node = new TreeNode(Integer.parseInt(ele));
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
