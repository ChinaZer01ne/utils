package com.github.arithmetic.structure;

import java.util.Arrays;

/**
 * 一个数组行和列都排好序了，找到指定的数
 * @Author: Zer01ne
 * @Date: 2019/1/17 15:22
 * @Version 1.0
 */
public class FindNum {
    public static void main(String[] args) {
        int[][] arr = createMatrix(12, 12);
        normalPrintMatrix(arr);
        System.out.println("==============================");
        System.out.println(Arrays.toString(findNum(arr, 144)));
    }

    private static int[] findNum(int[][] arr,int num){
        //从右上角开始找，如果当前数，比num小，则往下走，如果大，就往左走，两种情况
        //从左下角找类似
        //不从左上和右下找的原因是：左上，如果比当前数大，往右或者往下走都可以，右下同理，只有一种情况，难区分
        int row = 0;
        int column = arr[0].length - 1;

        while (row < arr.length && column > 0){
            if (arr[row][column] < num){
                row++;
            }else if (arr[row][column] > num){
                column--;
            }else {
                return new int[]{row,column};
            }
        }

        return null;
    }

    //创建矩阵
    private static int[][] createMatrix(int rows, int columns){
        int[][] maxtrix = new int[rows][columns];
        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                maxtrix[i][j] = num++;
            }
        }
        return maxtrix;
    }
    //普通打印
    private static void normalPrintMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
