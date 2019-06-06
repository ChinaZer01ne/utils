package com.github.arithmetic.offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * 数组中重复的数字
 * 时间限制：1秒 空间限制：32768K 热度指数：237675
 * 本题知识点： 数组
 *  算法知识视频讲解
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * 示例1
 * 输入
 * 复制
 * 输出
 * 复制
 *
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/6 17:30
 */
public class 数组中重复的数字 {



    /**
     * 思路：
     *
     *
     * */
    public boolean duplicateWithoutExtra(int numbers[],int length,int [] duplication) {
        //for (int i = 0; i < length; i++) {
        //    int index = numbers[i];
        //    //if (index >= length){
        //    //
        //    //}
        //    if (numbers[index] >= length){
        //    }
        //
        //    numbers[index] = numbers[index] + length;
        //}
        return true;
    }






    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[],int length,int [] duplication) {


        Map<Integer,Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < length; i++) {
            map.put(numbers[i],map.get(numbers[i]) == null ? 1 : map.get(numbers[i]) + 1);
        }

        for (Map.Entry<Integer,Integer> entry:
             map.entrySet()) {
            if(entry.getValue() > 1){
                duplication[0] = entry.getKey();
                return true;
            }
        }
        return false;


    }


    public static void main(String[] args) {

        数组中重复的数字 a = new 数组中重复的数字();
        int[] d = new int[1];
        System.out.println(a.duplicate(new int[]{2, 1, 3, 1, 4}, 5, d));
        System.out.println(d[0]);
    }
}
