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

        //int[] sequence = new int[]{1,2,3,4,5};
        int[] sequence = new int[]{5,4,3,2,1};

        System.out.println(VerifySquenceOfBST(sequence));
    }




    //大神写的递归版本，是真的简短
    public static boolean VerifySquenceOfBST2(int [] sequence){
        if(sequence.length == 0){
            return false;
        }
        return judge(sequence, 0, sequence.length - 1);
    }

    private static boolean judge(int[] sequence, int l, int r) {

        if (l > r){
            return true;
        }

        int i = r;
        //大于区域
        while (i > 1 && sequence[i - 1] > sequence[r]){
            --i;
        }


        //小于区域
        for(int j = i - 1; j >= l; --j){
            if(sequence[j] > sequence[r]){
                return false;
            }
        }
        return judge(sequence, l, i - 1) && (judge(sequence, i, r - 1));
    }


    //非递归，是真的骚
    public static boolean VerifySquenceOfBST3(int [] sequence){


            int size = sequence.length;
            if(size == 0){
                return false;
            }

            int i = 0;
            while(--size > 0)
            {
                while(sequence[i++]<sequence[size]);
                while(sequence[i++]>sequence[size]);

                if(i < size){
                    return false;
                }

                i=0;
            }

            return true;
        }



    /** 后序遍历，最后一个数是根节点，小于根节点的是左子树，大于根节点的右子树，然后递归*/
    public static boolean VerifySquenceOfBST(int [] sequence) {

        if (sequence == null || sequence.length == 0){
            return false;
        }

        return process(sequence);
    }

    private static boolean process(int [] sequence){
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

        int[] rightTree = new int[]{};
        if (leftIndex < rightIndex){
            rightTree = Arrays.copyOfRange(sequence, leftIndex + 1, rightIndex);
            for (int i = 0; i < rightTree.length; i++) {
                if (rightTree[i] < root){
                    return false;
                }
            }
        }


        int[] leftTree = Arrays.copyOfRange(sequence, 0, leftIndex);
        for (int i = 0; i < leftTree.length; i++) {
            if (leftTree[i] > root){
                return false;
            }
        }


        return  process(leftTree) && process(rightTree);
    }
}
