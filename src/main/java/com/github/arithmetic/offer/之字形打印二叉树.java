package com.github.arithmetic.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * 按之字形顺序打印二叉树
 * 时间限制：1秒 空间限制：32768K 热度指数：181228
 *  算法知识视频讲解
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/12 16:01
 */
public class 之字形打印二叉树 {




    /** 思路：实现最容易的
     *
     *      使用两个栈
     *      设立一个标志表名打印的顺序
     *
     *      如果从左往右打印，则从右往左压栈
     *      如果从右往左打印，则从左往右压栈
     * */
    public ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (pRoot == null){
            return result;
        }

        Stack<TreeNode> leftToRightStack = new Stack<>();
        Stack<TreeNode> rightToLeftstack = new Stack<>();
        boolean leftToRight = true;
        leftToRightStack.push(pRoot);


        while (!leftToRightStack.isEmpty() || !rightToLeftstack.isEmpty()){

            //如果要从左往右打印
            if (leftToRight){

                ArrayList<Integer> storey = new ArrayList<>();

                while (!leftToRightStack.isEmpty()){

                    TreeNode node = leftToRightStack.pop();
                    //打印
                    storey.add(node.val);
                    //把栈中的元素以左右的顺序压到rightToLeftstack栈，为了下次以右左的顺序打印
                    if (node.left != null){
                        rightToLeftstack.push(node.left);
                    }
                    if (node.right != null){
                        rightToLeftstack.push(node.right);

                    }
                }
                result.add(storey);
                leftToRight = false;
            }else {
                ArrayList<Integer> storey = new ArrayList<>();

                while (!rightToLeftstack.isEmpty()){
                    TreeNode node = rightToLeftstack.pop();
                    //打印
                    storey.add(node.val);

                    //把栈中的元素以右左的顺序压到rightToLeftstack栈，为了下次以左右的顺序打印
                    if (node.right != null){
                        leftToRightStack.push(node.right);
                    }
                    if (node.left != null){
                        leftToRightStack.push(node.left);
                    }
                }
                result.add(storey);
                leftToRight = true;
            }
        }

        return result;
    }

    /** 思路： 采用队列
     *
     *  1、首先压入根节点
     *  2、先压入右子树，再压入左子树
     *  3、先压入左子树，在压入右子树
     *
     *  采用一个标志位来表名从左到右，或者从右到左
     *
     *
     * */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {



        return null;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
