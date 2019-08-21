package com.github.arithmetic.offer;

/**
 *
 * 【第11题】 二进制中1的个数
 * 时间限制：1秒 空间限制：32768K 热度指数：342401
 *
 * 思路：短除法求1的个数，负数的时候还要考虑补位的情况
 * 题目描述
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * @author Zer01ne
 * @since 2019/3/13 22:52
 */
public class 二进制中1的个数 {

    public static void main(String[] args) {
        System.out.println(NumberOf1(-1234567));
        System.out.println(-1 % 2);
    }

    public static int NumberOf1(int n) {

        int num = n;
        //二进制中短除取余后1的个数
        int count = 0;
        //如果是负数，补位1的个数
        int bitCount = 0;


        while (n != 0){
            //注意负数对2取余会出现-1的情况，下面是分别考虑正数和负数的情况（出现1的个数）
            if (n % 2 == 1 || n % 2 == -1){
                count++;
            }
            n = n / 2;
            //二进制长度
            bitCount++;
        }

        if (num < 0){
            //32 - bitCount表示补位1的个数，当为负数的时候才会出现补位
            count = count + (32 - bitCount);
        }
        return count;
    }




    // 类似掩码的思想
    private static int NumberOf1_low(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    // 最优解
    public static int NumberOf12(int n) {
        int count = 0;
        while (n != 0) {
            ++count;
            // 每经过一次此操作，最右边的1就会被变成0，有多少次操作就有多少个1
            n = (n - 1) & n;
        }
        return count;
    }
}
