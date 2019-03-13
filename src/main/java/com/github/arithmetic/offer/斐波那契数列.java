package com.github.arithmetic.offer;

/**
 * 【第8题】
 * 斐波那契数列
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：462572
 *
 * 题目描述
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 *
 * @Author: Zer01ne
 * @Date: 2019/3/13 17:49
 * @Version 1.0
 */
public class 斐波那契数列 {

    public static void main(String[] args) {

    }
    /**
     * 普通递归
     */
    private int fibonacci(int n) {
        if (n == 0){
            return 0;
        }

        if (n == 1){
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);

    }

    private int[] cache = new int[39];
    /**
     *  递归内部缓存
     */
    private int fibonacci2(int n) {
        if (n == 0){
            cache[0] = 0;
            return 0;
        }

        if (n == 1){
            cache[1] = 1;
            return 1;
        }
        if (cache[n - 1] == 0){
            cache[n - 1] = fibonacci(n - 1);
        }
        if (cache[n - 2] == 0){
            cache[n - 2] = fibonacci(n - 2);
        }
        return cache[n - 1] + cache[n - 2];

    }

}
