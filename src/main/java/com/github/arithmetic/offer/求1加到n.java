package com.github.arithmetic.offer;

/**
 *
 * 求1+2+3+...+n     TODO 这个操作真的骚
 * 时间限制：1秒 空间限制：32768K 热度指数：152375
 *  算法知识视频讲解
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * @Author: Zer01ne
 * @Date: 2019/3/27 16:17
 * @Version 1.0
 */
public class 求1加到n {

    public static void main(String[] args) {
        System.out.println(Sum_Solution(10));
    }

    /**
     * 妙啊！利用短路与的特性，来控制右边逻辑的执行与否，来达到终止递归的目的
     */
    public static int Sum_Solution(int n) {

        int result = n;

        boolean t = ((result != 0) && ((result += Sum_Solution(n - 1)) != 0));

        return result;
    }
}
