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
     *
     *
     * 0011         0011
     * 0101         0101
     *
     * 0110         0001 << 1   0010
     *
     * num1 = 0110
     * num2 = 0010
     *
     * 0100     0010 << 1 0100
     *
     * num1 = 0100
     * num2 = 0100
     *
     * 0000     0100 << 1 1000
     *
     * num1 = 0000
     * num2 = 1000
     *
     * 1000     0000 << 1 0000
     *
     * return 1000
     * */
    public static int Add(int num1,int num2) {

        //进位值为零则跳出循环
        while (num2 != 0){
            //不进位求值，相当于有异或操作
            int temp = num1 ^ num2;
            //进位求值，与操作然后左移
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }

        return num1;
    }
}
