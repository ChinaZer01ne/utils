package com.github.arithmetic.offer;

import java.util.ArrayList;

/**
 *
 * 和为S的两个数字
 * 时间限制：1秒 空间限制：32768K 热度指数：210233
 *  算法知识视频讲解
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/6 14:20
 */
public class 和为S的两个数字 {



    /**
     *
     * 思路：设置头尾两个指针和
     *
     * 如果  arr[p1] + arr[p2] == sum ,就是答案（相差越远乘积越小）
     * 如果  arr[p1] + arr[p2] > sum ,那么p2--,arr[p2]肯定不是答案之一（前面已得出 p1 前面的数已是不可能）
     * 如果  arr[p1] + arr[p2] < sum ,那么p1++,arr[p1]肯定不是答案之一（前面已得出 j 后面的数已是不可能）
     *
     *
     * */
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        int p1 = 0;
        int p2 = array.length - 1;
        while (p1 <= p2){
            if (array[p1] + array[p2] == sum){
                result.add(array[p1]);
                result.add(array[p2]);
                return result;
            }else if (array[p1] + array[p2] > sum){
                p2 -= 1;
            }else {
                p1 += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
