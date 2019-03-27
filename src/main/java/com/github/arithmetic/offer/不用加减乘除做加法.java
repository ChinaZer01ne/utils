package com.github.arithmetic.offer;

/**
 * 不用加减乘除做加法 TODO
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：100042
 *  算法知识视频讲解
 * 题目描述
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * @author Zer01ne
 * @since 2019/3/27 22:28
 */
public class 不用加减乘除做加法 {

    public static void main(String[] args) {
        System.out.println(Add(3, 5));
    }
    /**
     * 0011
     * +
     * 0101
     * =
     * 1000
     * */
    public static int Add(int num1,int num2) {
        return num1 ^ num2;
    }
}
