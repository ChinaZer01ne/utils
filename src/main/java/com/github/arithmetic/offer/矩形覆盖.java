package com.github.arithmetic.offer;
/**
 *
 * 【第10题】矩形覆盖
 * 时间限制：1秒 空间限制：32768K 热度指数：256642
 *
 * 题目描述
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * @author Zer01ne
 * @since 2019/3/13 22:49
 */
public class 矩形覆盖 {

    public static void main(String[] args) {
        System.out.println(RectCover(4));
    }

    public static int RectCover(int target) {

        if (target == 1){
            return 1;
        }
        if (target == 2){
            return 2;
        }


        return RectCover(target - 2)  + RectCover(target - 1) ;

    }
}
