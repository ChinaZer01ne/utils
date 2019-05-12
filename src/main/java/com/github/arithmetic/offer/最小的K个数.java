package com.github.arithmetic.offer;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * 最小的K个数
 * 时间限制：1秒 空间限制：32768K 热度指数：425987
 * 本题知识点： 数组
 *  算法知识视频讲解
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 *
 * @author Zer01ne
 * @since 2019/5/12 9:52
 */
public class 最小的K个数 {

    /** 思想：堆*/
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {


        ArrayList<Integer> arrayList = new ArrayList<>();

        if (k > input.length){
            return arrayList;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < input.length; i++) {
            queue.add(input[i]);
        }

        for (int i = 0; i < k; i++) {

            arrayList.add(queue.poll());
        }

        return arrayList;
    }
}
