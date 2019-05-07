package com.github.arithmetic.offer;

import java.time.Instant;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * 数据流中的中位数
 * 时间限制：1秒 空间限制：32768K 热度指数：136388
 *  算法知识视频讲解
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/7 13:22
 */
public class 数据流中的中位数 {
    public static void main(String[] args) {
        Insert(5);
        System.out.println(GetMedian());
        Insert(2);
        System.out.println(GetMedian());
        Insert(3);
        System.out.println(GetMedian());
        Insert(4);
        System.out.println(GetMedian());
        Insert(1);
        System.out.println(GetMedian());
        Insert(6);
        System.out.println(GetMedian());
        Insert(7);
        System.out.println(GetMedian());
        Insert(0);
        System.out.println(GetMedian());
        Insert(8);
        System.out.println(GetMedian());
    }

    private static PriorityQueue<Integer> smallHeap = new PriorityQueue<>((Comparator.comparingInt(o -> o)));
    private static PriorityQueue<Integer> bigHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public static void Insert(Integer num) {


        if (!smallHeap.isEmpty() && num > smallHeap.peek()){
            smallHeap.add(num);
        }else {
            bigHeap.add(num);
        }

        if (bigHeap.size() - smallHeap.size() >= 1){
            smallHeap.add(bigHeap.poll());
        }else if (smallHeap.size() - bigHeap.size() >= 1){
            bigHeap.add(smallHeap.poll());
        }


    }

    public static Double GetMedian() {


        if (bigHeap.size() == smallHeap.size()){
            return bigHeap.peek() / 2.0 + smallHeap.peek() / 2.0;
        }else if (bigHeap.size() > smallHeap.size()){
            return Double.valueOf(bigHeap.peek());
        }else {
            return Double.valueOf(smallHeap.peek());
        }

    }

}
