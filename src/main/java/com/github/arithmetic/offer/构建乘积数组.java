package com.github.arithmetic.offer;

/**
 *
 * 构建乘积数组
 * 时间限制：1秒 空间限制：32768K 热度指数：118704
 * 本题知识点： 数组
 *  算法知识视频讲解
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/11 12:47
 */
public class 构建乘积数组 {

    public static void main(String[] args) {
        构建乘积数组 a = new 构建乘积数组();
        a.multiply(new int[]{1,2,3,4,5});
    }
    /** 思路：
     *      第一种：N^2，遍历就可以了
     *      第二种：
     * */
    public int[] multiply(int[] A) {

        int[] B = new int[A.length];

        for (int i = 0; i < B.length; i++) {

            int multiply = 1;

            for (int j = 0; j < A.length; j++) {
                if (i == j){
                    continue;
                }
                multiply *= A[j];
            }
            B[i] = multiply;
        }
        return B;
    }
}
