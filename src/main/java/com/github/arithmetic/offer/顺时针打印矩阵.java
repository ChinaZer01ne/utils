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

        //左上
        int tR = 0;
        int tC = 0;
        //右下
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;

        ArrayList<Integer> arrayList = new ArrayList<>();


        return printMatrix(matrix,arrayList,tR,tC,dR,dC);

    }

    private static ArrayList<Integer> printMatrix(int[][] matrix,  ArrayList<Integer> arrayList, int tR, int tC, int dR, int dC) {

        if (tC > dC || tR > dR){
            return arrayList;
        }
        //while (tC <= dC && tR <= dR){
        //说明只有一行
        if (tR == dR){
            for (int i = tC; i <= dC; i++) {
                arrayList.add(matrix[tR][i]);
            }
            return arrayList;
        }
        //说明只有一列
        if (tC == dC){
            for (int i = tR; i <= dR; i++) {
                arrayList.add(matrix[i][tC]);
            }
            return arrayList;
        }


        //其他情况
        for (int i = tC; i < dC; i++) {
            arrayList.add(matrix[tC][i]);
        }
        for (int i = tR; i < dR; i++) {
            arrayList.add(matrix[i][dC]);
        }
        for (int i = dC; i > tC; i--) {
            arrayList.add(matrix[dR][i]);
        }
        for (int i = dR; i > tR; i--) {
            arrayList.add(matrix[i][tC]);
        }

        tC++;
        tR++;
        dC--;
        dR--;
        //}
        printMatrix(matrix,arrayList,tR,tC,dR,dC);
        return arrayList;
    }
}
