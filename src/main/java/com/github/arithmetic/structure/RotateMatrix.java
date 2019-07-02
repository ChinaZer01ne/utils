package com.github.arithmetic;

import java.util.Arrays;

/**
 * 旋转矩阵
 * @Author: Zer01ne
 * @Date: 2019/1/16 17:57
 * @Version 1.0
 */
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = createMatrix(12, 12);
        normalPrintMatrix(matrix);
        System.out.println("==============================");
        rotateMatrix(matrix,0,0,11,11);
        normalPrintMatrix(matrix);
        System.out.println("==============================");
    }
    private static void rotateMatrix(int[][] matrix,int tR, int tC,int dR, int dC){


        //首先四个角位置变换（0，0）-》 （0，11），（0，11），（11，11）。。。，然后下一次循环（0，1）-》（1，11）。。。，外边一圈旋转完后，坐标往里缩，依次进行内圈的旋转
        while (tC < dC && tR < dR){
            for (int i = tR; i < dR; i++) {
                int temp = matrix[tR][tC + i];
                matrix[tR][tC + i] = matrix[dR - i][tC];
                matrix[dR - i][tC] =  matrix[dR][dC - i];
                matrix[dR][dC - i] =  matrix[tR + i][dC];
                matrix[tR + i][dC] = temp;
            }

            tR++;
            tC++;
            dR--;
            dC--;
        }

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
