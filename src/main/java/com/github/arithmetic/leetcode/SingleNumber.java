package com.github.arithmetic.leetcode;

/**
 *
 *
 * single-number
 * 时间限制：1秒 空间限制：32768K 热度指数：15945
 * 本题知识点： 复杂度 leetcode
 *  算法知识视频讲解
 * 题目描述
 *
 * Given an array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/11 17:32
 */
public class SingleNumber {

    public static void main(String[] args) {
        int[] a = new int[]{2,2,1};
        System.out.println(singleNumber(a));
    }
    /**
     * 思路：异或，因为只有1个是出现一次的，所以最后异或的值就是单一的数字
     *
     * 1.异或满足交换律。
     * 2.相同两个数异或为0。
     * 3.0异或一个数为那个数本身。
     */
    public static int singleNumber(int[] A) {

        if (A.length == 1){
            return A[0];
        }

        int num = 0;
        for (int i = 0; i < A.length; i++) {
            num = num ^ A[i];
        }
        return num;
    }
}
