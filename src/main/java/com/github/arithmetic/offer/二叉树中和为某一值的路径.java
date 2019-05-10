package com.github.arithmetic.offer;

import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * 二叉树中和为某一值的路径
 * 时间限制：1秒 空间限制：32768K 热度指数：347799
 *  算法知识视频讲解
 * 题目描述
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/10 16:56
 */
public class 二叉树中和为某一值的路径 {


    static ArrayList<ArrayList<Integer>> all = new ArrayList<>();

    /** 先序遍历 递归,target做减法*/
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        return null;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(10);
        TreeNode node7 = new TreeNode(16);

        root.left = node2;
        root.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node3.left = node7;

        walk(new ArrayList<>(),root,24);

        System.out.println(all.size());

        for (ArrayList<Integer> list:
             all) {
            for (Integer i:
                 list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
    }

    public static ArrayList<Integer> walk(ArrayList<Integer> list,TreeNode root, int target) {

        if (root == null){
            return new ArrayList<>();
        }

        target = target - root.val;
        if (target == 0){
            all.add(list);
            return list;
        }else if (target < 0){
            return null;
        }

        walk(list,root.left, target);

        walk(list,root.right, target);

        return list;
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
