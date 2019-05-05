package com.github.arithmetic.coderreview;

/**
 *
 * 无缓存交换
 * 时间限制：3秒 空间限制：32768K 热度指数：4748
 * 本题知识点： 编程基础
 *  算法知识视频讲解
 * 题目描述
 * 请编写一个函数，函数内不使用任何临时变量，直接交换两个数的值。
 *
 * 给定一个int数组AB，其第零个元素和第一个元素为待交换的值，请返回交换后的数组。
 *
 * 测试样例：
 * [1,2]
 * 返回：[2,1]
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/5 11:29
 */
public class 无缓存交换 {

    public int[] exchangeAB(int[] AB) {
        // write code here
        int a = AB[0];
        int b = AB[1];

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        AB[0] = a;
        AB[1] = b;

        return AB;
    }

}
