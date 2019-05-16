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


    ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    /** 先序遍历 递归,target做减法*/
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if (root == null){
            return listAll;
        }

        list.add(root.val);

        target -= root.val;

        if (target == 0 && root.left == null && root.right == null){
             listAll.add(new ArrayList<>(list));
        }

        FindPath(root.left,target);
        FindPath(root.right,target);

        list.remove(list.size() - 1);

        return listAll;

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


        二叉树中和为某一值的路径 e = new 二叉树中和为某一值的路径();
        e.FindPath(root,24);

        System.out.println(e.listAll.size());

        for (ArrayList<Integer> list:
             e.listAll) {
            for (Integer i:
                 list) {
                System.out.print(i + "\t");
            }
            System.out.println();
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
