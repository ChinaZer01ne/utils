package com.github.arithmetic.offer;

/**
 * 【第10题】
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：283345
 *
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author Zer01ne
 * @since 2019/3/13 21:39
 */
public class 变态跳台阶 {

    public static void main(String[] args) {
        System.out.println(JumpFloorII(3));
        System.out.println(JumpFloorII(4));
        System.out.println(JumpFloorII(6));
    }
    /**
     * 这个应该怎么理解呢 TODO
     */
    public static int JumpFloorII(int target) {

        // 基础case
        if (target <= 2){
            return target;
        }

        // n-1级台阶的情况
        int sum = JumpFloorII(target - 1);
        // 从n-1级台阶到n级台阶有1种，也就是有sum种
        // 连续跳n-1级台阶到n级台阶有两种情况
        // 从1到n-1，再跳一级
        // 先跳一级，然后从2到n-1
        // 所以是sum += sum
        sum += sum;

        return sum;
    }
}
