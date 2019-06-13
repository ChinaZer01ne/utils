package com.github.arithmetic.offer;

import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 *
 * 把二叉树打印成多行
 * 时间限制：1秒 空间限制：32768K 热度指数：144610
 *  算法知识视频讲解
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/12 16:31
 */
public class 把二叉树打印成多行 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node2 = new TreeNode(4);
        //TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(3);
        //TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(2);
        //TreeNode node7 = new TreeNode(11);

        root.left = node2;
        //root.right = node3;

        node2.left = node4;
        //node2.right = node5;

        //node3.left = node6;
        //node3.right = node7;
        node4.left = node6;

        把二叉树打印成多行 a = new 把二叉树打印成多行();

        ArrayList<ArrayList<Integer>> print = a.Print(root);

        print.forEach(integers -> {
            System.out.println(Arrays.toString(integers.stream().toArray()));
        });


    }
    /** 二叉树的层级遍历 */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {


        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if(pRoot == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> depth = new ArrayList<>();

        queue.add(pRoot);

        int start = 0, end = 1;

        while (!queue.isEmpty()){

            TreeNode node = queue.remove();

            depth.add(node.val);

            start ++;

            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }

            if(start == end){
                end = queue.size();
                start = 0;
                result.add(depth);
                depth = new ArrayList<>();
            }
        }
        return result;
    }

    /** 递归 */
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        depth(pRoot, 1, list);
        return list;
    }

    private void depth(TreeNode root, int depth, ArrayList<ArrayList<Integer>> list) {
        if (root == null){
            return;
        }

        if (depth > list.size()){
            list.add(new ArrayList<>());
        }

        list.get(depth - 1).add(root.val);

        depth(root.left,depth + 1,list);
        depth(root.right,depth + 1,list);


    }


    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
