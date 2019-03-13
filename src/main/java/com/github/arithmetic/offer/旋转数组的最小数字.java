package com.github.arithmetic.offer;

/**
 * 时间限制：3秒 空间限制：32768K 热度指数：496552
 * 本题知识点： 查找
 *
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @Author: Zer01ne
 * @Date: 2019/3/13 17:33
 * @Version 1.0
 */
public class 旋转数组的最小数字 {
    public static void main(String[] args) {

    }

    public int minNumberInRotateArray(int [] array) {

        if (array == null || array.length == 0){
            return 0;
        }
        //记录下当前位置
        int preMin = array[0];

        for (int i = 1; i < array.length; i++) {
            //如果当前位置大于下一个位置，则下一个位置就是最小值，返回下一个位置。否则。当前位置往下移动
            if (preMin > array[i]){
                return array[i];
            }
            preMin = array[i];
        }

        return preMin;
    }
}
