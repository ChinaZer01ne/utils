package com.github.arithmetic;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 转圈打印矩阵
 * @Author: Zer01ne
 * @Date: 2019/1/14 10:38
 * @Version 1.0
 */
public class CircularPrintMatrix {

    public static void main(String[] args) {
        int[][] matrix = createMatrix(10, 12);
        normalPrintMatrix(matrix);
        System.out.println("==============================");
        circularPrintMatrix(matrix,10,12);
        System.out.println("==============================");
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
    //转圈打印1
    private static void circularPrintMatrix(int[][] matrix,int rows, int columns){
        if (rows == 1){
            System.out.println(Arrays.toString(matrix[0]));
        }else if (columns == 1){
            for (int i = 0; i < matrix.length; i++) {
                System.out.println(matrix[i][0]);
            }
        }else {
            for (int i = 0; i < rows; i++) {
                for (int j = i; j < columns; j++) {
                    System.out.print(matrix[i][j]);
                    System.out.print("\t");
                }
                System.out.println();
                for (int k = i + 1; k < rows - 1; k++) {
                    System.out.print(matrix[k][columns - 1]);
                    System.out.print("\t");
                }
                System.out.println();
                for (int m = columns -i - 1; m > i; m--) {
                    System.out.print(matrix[rows - 1][m]);
                    System.out.print("\t");
                }
                System.out.println();
                for (int n = rows - 1; n > i; n--) {
                    System.out.print(matrix[n][i]);
                    System.out.print("\t");
                }
                System.out.println();
                rows--;
                columns--;
            }
        }

    }
    private static void circularPrintMatrix2(int[][] matrix,int LR, int LC,int RR, int RC){

    }
}
