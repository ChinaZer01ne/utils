package com.github.arithmetic.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * 丑数
 * 时间限制：1秒 空间限制：32768K 热度指数：267611
 * 本题知识点： 数组
 *  算法知识视频讲解
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/30 10:31
 */
public class 丑数 {
    public static void main(String[] args) {

    }

    public int GetUglyNumber_Solution(int index) {
        //0-6丑数分别是0-6
        if (index < 7){
            return index;
        }

        List<Integer> list = new ArrayList<>();

        //指向2，3，5的指针
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        //队列最小值
        int num = 1;

        list.add(1);




        while (list.size() < index){
            //选出三个队列头最小的数
            num = Math.min(list.get(p2) * 2, Math.min(list.get(p3) * 3,list.get(p5) * 5));
            //这三个if有可能进入一个或者多个，进入多个是三个队列头最小的数有多个的情况
            if (list.get(p2) * 2 == num) {
                p2++;
            }
            if (list.get(p3) * 3 == num) {
                p3++;
            }
            if (list.get(p5) * 5 == num) {
                p5++;
            }
            list.add(num);
        }

        return num;


    }
}
