package com.github.arithmetic;

import java.util.Arrays;


/**
 * 之字形打印矩阵(我数组坐标经常想不明白。。。)
 * @Author: Zer01ne
 * @Date: 2019/1/17 13:12
 * @Version 1.0
 */
public class SnakePrintMatrix {
    public static void main(String[] args) {
        int[][] matrix = createMatrix(12, 12);
        normalPrintMatrix(matrix);
        System.out.println("==============================");
        snakePrintMatrix(matrix);
        System.out.println("==============================");
    }
    private static void snakePrintMatrix(int[][] matrix){

        int aR = 0;
        int aC = 0;
        int bR = 0;
        int bC = 0;
        int endRows = matrix.length - 1;
        int endColumn = matrix[0].length - 1;
        boolean direction = true;

        while (aR != endRows + 1){
            printLine(matrix,aR,aC,bR,bC,direction);

            //坐标的变换
            aR = aC == endColumn ? aR + 1 : aR;
            bC = bR == endRows ? bC + 1 : bC;
            aC = aC == endColumn ? aC :aC + 1;
            bR = bR == endRows ? bR : bR + 1;

            direction = !direction;
        }
    }

    private static void printLine(int[][] matrix,int aR, int aC, int bR, int bC, boolean upToDown) {
        if (upToDown){
            while (aR != bR + 1){
                System.out.print(matrix[aR++][aC--] + "\t");
            }
        }else {
            while (bR != aR - 1){
                System.out.print(matrix[bR--][bC++] + "\t");
            }
        }
        System.out.println();
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
