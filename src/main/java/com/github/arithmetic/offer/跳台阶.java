package com.github.arithmetic.offer;
/**
 * 【第9题】
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：355906
 *
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * 思路：想了想发现，
 * 比如，想到第三台阶，有两种选择：1、从第二台阶走一步到第三台阶；2、从第一台阶走两步到第三台阶
 * 想到第十台阶，有两种选择：1、从第九台阶走一步到第十台阶；2、从第八台阶走两步到第十台阶
 * 最后的选择，决定了到最后整体不一样（到第九台阶和到第八台阶可能存在重复的选择，但最后一步导致整体不重复）
 * 所以能得出 ：【到第n台阶的步数 = 到第n-1台阶的步数 + 到第n-2台阶的步数】
 *
 * @author Zer01ne
 * @since 2019/3/13 21:15
 */
public class 跳台阶 {

    public static void main(String[] args) {
        System.out.println(JumpFloor(3));
        System.out.println(JumpFloor(4));
        System.out.println(JumpFloor(5));
    }

    private static int JumpFloor(int target) {

        if (target <= 3){
            return target;
        }
        //【到第n台阶的步数 = 到第n-1台阶的步数 + 到第n-2台阶的步数】,思路在题目下方
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }
}
