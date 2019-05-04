package com.github.arithmetic.offer;

import java.util.ArrayList;
/**
 * 顺时针转圈打印矩阵
 * 时间限制：1秒 空间限制：32768K 热度指数：463919
 * 本题知识点： 数组
 *  算法知识视频讲解
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 *
 * @author Zer01ne
 * @since 2019/5/4 21:53
 */
public class 顺时针打印矩阵 {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15}
        };
        //matrix = new int[][]{
        //        {1,2},{3,4}
        //};
        ArrayList<Integer> arrayList = printMatrix(matrix);
        arrayList.stream().forEach(System.out::println);
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> arrayList = new ArrayList<>();


        //左上
        int LTx = 0;
        int LTy = 0;
        //右下
        int RDx = matrix.length - 1;
        int RDy = matrix[0].length - 1;


        if (LTx == RDx){
            for (int i = 0; i < matrix[0].length; i++) {
                arrayList.add(matrix[0][i]);
            }
            return arrayList;
        }else if (LTy == RDy){
            for (int i = 0; i < matrix.length; i++) {
                arrayList.add(matrix[i][0]);
            }
            return arrayList;
        }

        while (LTy <= RDy && LTx <= RDx ){
            for (int i = LTy; i <= RDy - 1; i++) {
                arrayList.add(matrix[LTx][i]);
            }

            for (int i = LTx; i <= RDx - 1 ; i++) {
                arrayList.add(matrix[i][RDy]);
            }

            for (int i = RDy; i >= LTy + 1; i--) {
                arrayList.add(matrix[RDx][i]);
            }

            for (int i = RDx ; i >= LTx + 1; i--) {
                arrayList.add(matrix[i][LTy]);
            }
            LTy++;
            RDy--;
            LTx++;
            RDx--;
        }
        return arrayList;
    }
}
