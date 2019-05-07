package com.github.arithmetic.offer;

import java.util.ArrayList;

/**
 *滑动窗口的最大值
 * 时间限制：1秒 空间限制：32768K 热度指数：173805
 *  算法知识视频讲解
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/7 11:33
 */
public class 滑动窗口最大值 {

    public ArrayList<Integer> maxInWindows(int [] num, int size) {


        ArrayList<Integer> list = new ArrayList<>();

        if (size == 0){
            return list;
        }

        //滑动窗口边界
        int startIndex = 0;
        int endIndex = size - 1;
        int maxValueIndex = 0;
        /** 思路：*/
        for (int j = endIndex; j < num.length; j++) {

            ////如果最大值索引在滑动窗口内，并且比新值大，则最大值不变
            //if (maxValueIndex > startIndex && num[maxValueIndex] > num[endIndex]){
            //    list.add(num[maxValueIndex]);
            //    startIndex++;
            //    endIndex++;
            //    continue;
            //}
            //
            int maxValue = Integer.MIN_VALUE;
            //每一个滑动窗口中的最大值
            for (int i = startIndex; i <= endIndex; i++) {

                if (num[i] > maxValue){
                    maxValue = num[i];
                    maxValueIndex = i;
                }
            }
            list.add(maxValue);
            startIndex++;
            endIndex++;
        }

        return list;

    }
}
