package com.github.arithmetic.coderreview;

/**
 * 整数转化
 * 时间限制：3秒 空间限制：32768K 热度指数：5861
 *  算法知识视频讲解
 * 题目描述
 * 编写一个函数，确定需要改变几个位，才能将整数A转变成整数B。
 *
 * 给定两个整数int A，int B。请返回需要改变的数位个数。
 *
 * 测试样例：
 * 10,5
 * 返回：4
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/5 11:44
 */
public class 整数转化 {
    public int calcCost(int A, int B) {
        // write code here

        int ab = A ^ B;

        int count = 0;
        while (ab != 0){
            if (ab % 2 == 1){
                count++;
            }
            ab = ab / 2;
        }
        return count;
    }
}
