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
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {


        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (pRoot == null){
            return result;
        }


        int storey = 1;
        int nullCount = 1;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(pRoot);

        ArrayList<Integer> phase = new ArrayList<>();


        while (!queue.isEmpty()){

            TreeNode node = queue.poll();


            if (node == null){
                continue;
            }


            if ( Math.pow(2,storey) - 1 == nullCount ){
                //if (node != pRoot){
                result.add(phase);
            }

            phase.add(node.val);

            if ( Math.pow(2,storey) - 1 == nullCount ){
                //if (node != pRoot){
                storey++;
                //result.add(phase);
                phase = new ArrayList<>();
                //}else {
                //    storey++;
                //}

            }


            if (node.left != null){
                queue.add(node.left);
            }else {
                queue.add(null);
            }

            nullCount ++;

            if (node.right != null){
                queue.add(node.right);
            }else {
                queue.add(null);
            }

            nullCount ++;


        }


        return result;
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
