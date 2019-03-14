package com.github.arithmetic.offer;
/**
 * 【第13题】 调整数组顺序使奇数位于偶数前面
 * 时间限制：1秒 空间限制：32768K 热度指数：413529
 * 本题知识点： 数组
 *
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author Zer01ne
 * @since 2019/3/14 20:37
 */
public class 调整数组顺序使奇数位于偶数前面 {

    public static void main(String[] args) {
        int[] array = new int[]{2,4,6,1,3,5,7};
        reOrderArray(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
    /**
     * 思路：遍历判断
     */
    public static void reOrderArray(int [] array) {

        if (array == null || array.length < 2){
            return;
        }

        for (int i = 0; i < array.length; i++) {
            //奇数的时候就和他前面的偶数交换，有点像插排
            if (array[i] % 2 == 1){
                for (int j = i; j - 1 >= 0; j--) {
                    if (array[j - 1] % 2 == 0){
                        swap(array, j,j - 1);
                    }else {
                        break;
                    }
                }
            }
        }
    }
    private static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
