package com.github.arithmetic.offer;

import org.apache.ibatis.jdbc.SQL;

import java.util.Arrays;

/**
 *
 * 二叉搜索树的后序遍历序列
 * 时间限制：1秒 空间限制：32768K 热度指数：354117
 *  算法知识视频讲解
 * 题目描述
 *
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 *
 * @Author: Zer01ne
 * @Date: 2019/3/27 16:15
 * @Version 1.0
 */
public class 二叉搜索树的后序遍历序列 {

    public static void main(String[] args) {

        int[] sequence = new int[]{1,2,3,4,5};

        System.out.println(VerifySquenceOfBST(sequence));
    }

    /** 后序遍历，最后一个数是根节点*/
    public static boolean VerifySquenceOfBST(int [] sequence) {

        if (sequence == null){
            return false;
        }

        if (sequence.length < 3){
            return true;
        }
        //根节点
        int root = sequence[sequence.length - 1];
        //右子树根节点
        int rightIndex = sequence.length - 2;
        //左子树根节点
        int leftIndex = 0;

        //从倒数第二个位置，寻找比根节点值小的数，就是左字树的根节点
        for (int i = sequence.length - 2; i > 0; i--) {
            if (sequence[i] < root){
                leftIndex = i;
                break;
            }
        }


        int[] rightTree = Arrays.copyOfRange(sequence, leftIndex + 1, rightIndex);
        for (int i = 0; i < rightTree.length; i++) {
            if (rightTree[i] < root){
                return false;
            }
        }

        int[] leftTree = Arrays.copyOfRange(sequence, 0, leftIndex);
        for (int i = 0; i < leftTree.length; i++) {
            if (leftTree[i] > root){
                return false;
            }
        }


        return  VerifySquenceOfBST(leftTree) && VerifySquenceOfBST(rightTree);
    }
}
