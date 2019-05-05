package com.github.arithmetic.offer;

import org.apache.poi.ss.formula.functions.T;

import java.util.Arrays;
import java.util.Stack;

/**
 * 【第四题】TODO
 *
 * 重建二叉树。
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：538919
 *
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class 重建二叉树 {
    public static void main(String[] args) {

    }


    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {

        if (pre.length == 0 || in.length == 0){
            return null;
        }
        //根节点
        TreeNode node = new TreeNode(pre[0]);

        //找出中间的数
        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]){
                node.left = reConstructBinaryTree(Arrays.copyOfRange(pre,0,i + 1),Arrays.copyOfRange(pre,0,i + 1));
                node.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i + 1,pre.length),Arrays.copyOfRange(pre,i + 1,in.length));
            }
        }
        return node;
    }

    public int searchRootIndexAtIn(int[] in,int root){
        int rootIndexAtIn = 0;
        //找出中间的数
        for (int i = 0; i < in.length; i++) {
            if (in[i] == root){
                rootIndexAtIn = i;
            }
        }
        return rootIndexAtIn;
    }
}

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
}