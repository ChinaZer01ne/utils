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


    String Serialize(TreeNode root) {
        if (root == null){
            return "#";
        }else {
            return root.val + Serialize(root.left) + Serialize(root.right);
        }

    }
    TreeNode Deserialize(String str) {
        if ("".equals(str) || "#!".equals(str)){
            return null;
        }else {
            //TreeNode node = new TreeNode();
        }
        return null;
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

}
