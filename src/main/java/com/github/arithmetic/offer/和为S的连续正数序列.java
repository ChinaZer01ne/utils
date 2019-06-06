package com.github.arithmetic.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *和为S的连续正数序列
 * 时间限制：1秒 空间限制：32768K 热度指数：228153
 *  算法知识视频讲解
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/6 14:40
 */
public class 和为S的连续正数序列 {

    public static void main(String[] args) {
        和为S的连续正数序列 a = new 和为S的连续正数序列();
        ArrayList<ArrayList<Integer>> arrayLists = a.FindContinuousSequence(100);
        System.out.println(arrayLists.size());
    }
    /**
     * 思路：
     *  设置两个指针，p1,p2，起始位置在0位置处
     *      如果p1到p2小于sum，p2++
     *               等于sum，记录
     *               大于sum，p1++
     * */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        //存放结果
        ArrayList<ArrayList<Integer> > result = new ArrayList<>();
        int p1 = 1;
        int p2 = 2;

        while (p1 <= sum / 2 && p1 < p2){
            int total = (p2 + p1) * (p2 - p1 + 1) / 2;
            if (total < sum){
                p2++;
            }else if (total == sum){
                result.add(fill(p1,p2));
                p1++;
            }else {
                p1++;
            }
        }

        return result;
    }

    private ArrayList<Integer> fill(int a, int b){
        ArrayList<Integer> phase = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            phase.add(i);
        }
        return phase;
    }
}
