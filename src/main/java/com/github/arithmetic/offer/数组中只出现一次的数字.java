package com.github.arithmetic.offer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 数组中只出现一次的数字
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：195317
 * 本题知识点： 数组
 *  算法知识视频讲解
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 *
 * @author Zer01ne
 * @since 2019/3/26 21:51
 */
public class 数组中只出现一次的数字 {

    public static void main(String[] args) {

    }

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {

        if (array == null){
            return;
        }

        Map<Integer,Boolean> map = new HashMap<>();
        //这个标志法换成用数字记录出现次数更好
        for (int i = 0; i < array.length; i++) {

            Boolean aBoolean = map.get(array[i]);

            if (aBoolean != null){
                map.put(array[i], false);
            }else {
                map.put(array[i], true);
            }
        }
        int[] result = new int[2];
        int i = 0;
        for (Map.Entry entry:
             map.entrySet()) {
            Boolean value = (Boolean) entry.getValue();
            if (value){
                result[i] = (int) entry.getKey();
                i++;
            }
        }
        num1[0] = result[0];
        num2[0] = result[1];
    }

    //异或法 TODO
    public void FindNumsAppearOnce2(int [] array,int num1[] , int num2[]) {

    }
}
