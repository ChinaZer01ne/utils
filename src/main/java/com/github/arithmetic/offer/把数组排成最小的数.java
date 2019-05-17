package com.github.arithmetic.offer;

import java.util.*;

/**
 *
 * 把数组排成最小的数
 * 时间限制：1秒 空间限制：32768K 热度指数：233943
 * 本题知识点： 数组
 *  算法知识视频讲解
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 *
 * @author Zer01ne
 * @since 2019/5/12 10:06
 */
public class 把数组排成最小的数 {
    public String PrintMinNumber(int [] numbers) {


        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Integer> list= new ArrayList<Integer>();

        for(int i=0;i < numbers.length;i++){
            list.add(numbers[i]);

        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });


        for (int j :
                list) {
            stringBuilder.append(j);
        }

        return stringBuilder.toString();
    }


}
