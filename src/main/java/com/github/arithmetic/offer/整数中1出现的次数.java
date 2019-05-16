package com.github.arithmetic.offer;

/**
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：159633
 *  算法知识视频讲解
 * 题目描述
 *
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 * @Author: Zer01ne
 * @Date: 2019/3/27 17:43
 * @Version 1.0
 */
public class 整数中1出现的次数 {

    public static void main(String[] args) {
        System.out.println(NumberOf1Between1AndN_Solution(10));
    }


    /**
     * 思路：
     */
    public static int NumberOf1Between1AndN_Solution(int n) {

        if (n <= 0){
            return 0;
        }

        int count = 0;

        for (int i = 1; i <= n; i = i * 10) {
            long diviver = i * 10;
            count += (n / diviver) * i +  Math.min(Math.max(n % diviver - i + 1, 0),i);
        }

        return count;
    }
}
