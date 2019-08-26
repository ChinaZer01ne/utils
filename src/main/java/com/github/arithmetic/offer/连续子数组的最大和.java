package com.github.arithmetic.offer;

/**
 *
 * 连续子数组的最大和
 * 时间限制：1秒 空间限制：32768K 热度指数：230171
 * 本题知识点： 数组
 *  算法知识视频讲解
 * 题目描述
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/13 10:15
 */
public class 连续子数组的最大和 {

    public static void main(String[] args) {
        //int[] array = new int[]{6,-3,-2,7,-15,1,2,2};
        int[] array = new int[]{1,-2,3,10,-4,7,2,-5};
        System.out.println(FindGreatestSumOfSubArray2(array));
    }

    /** 思路：遇到负数抛弃前面的值，到但要记录最大值*/
    public static int FindGreatestSumOfSubArray3(int[] array) {
        return 0;
    }

    /** 思路：用一个值记录当前的最大和,求每一轮的最大值*/
    public static int FindGreatestSumOfSubArray2(int[] array) {

        if (array.length == 1){
            return array[0];
        }

        int result = array[0];

        for (int j = 0; j < array.length; j++) {
            int maxValue = array[0];
            int curValue = 0;

            for (int i = j; i < array.length; i++) {
                curValue = curValue + array[i];
                maxValue = curValue > maxValue ? curValue : maxValue;
            }
            result = maxValue > result ? maxValue : result;
        }

        return result;
    }

    /** 思路：最容易想的，遍历求出各个位置的和，然后再比较*/
    public int FindGreatestSumOfSubArray(int[] array) {
        return 0;
    }
/*
    动态规划
    链接：https://www.nowcoder.com/questionTerminal/459bd355da1549fa8a49e350bf3df484
    来源：牛客网*/

    public  int FindGreatestSumOfSubArray1(int[] array) {
        int res = array[0]; //记录当前所有子数组的和的最大值
        int max=array[0];   //包含array[i]的连续数组最大值
        for (int i = 1; i < array.length; i++) {
            max=Math.max(max+array[i], array[i]);
            res=Math.max(max, res);
        }
        return res;
    }

}
