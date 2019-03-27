package com.github.arithmetic.offer;

/**
 * 数字在排序数组中出现的次数
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：207565
 * 本题知识点： 数组
 *  算法知识视频讲解
 * 题目描述
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author Zer01ne
 * @since 2019/3/27 21:12
 */
public class 数字在排序数组中出现的次数 {

    public static void main(String[] args) {

    }

    /**
     * 思路：遍历，从头找
     * */
    public int GetNumberOfK(int [] array , int k) {


        int count = 0;

        for (int i = 0; i < array.length; i++) {

            if (array[i] == k){
                count++;
            }

        }

        return count;
    }

    /**
     * 思路：二分，找到后然后往两边扩散找，这个不是很好
     * */
    public int GetNumberOfK2(int [] array , int k) {

        int count = 0;

        int left = 0;
        int right = array.length - 1;

        //boolean find = false;
        int mid = -1;
        while (left <= right){

            mid = left + ((right - left) >> 1);

            if (array[mid] > k){
                right = mid - 1;
            }else if(array[mid] < k){
                left = mid + 1;
            }else {
                //find = true;
                count++;
                break;
            }
        }

        if (mid != -1){
            int offset = 1;
            while (mid + offset < array.length){
                if (array[mid + offset] == k){
                    count++;
                }else {
                    break;
                }
                offset++;
            }
            offset = -1;
            while (mid + offset > -1){
                if (array[mid + offset] == k){
                    count++;
                }else {
                    break;
                }
                offset--;
            }
        }
        return count;
        //int count = 0;
        //
        //for (int i = 0; i < array.length; i++) {
        //
        //    if (array[i] == k){
        //        count++;
        //    }
        //
        //}
        //
        //return count;
    }

    /**
     * 思路：二分，找到最左相等的数和最右相等的数，差值
     * */
    public int GetNumberOfK3(int [] array , int k) {
        return 0;
    }
}
