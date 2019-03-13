package com.github.arithmetic.offer;
/**
 * 【第11题】数值的整数次方
 * 时间限制：1秒 空间限制：32768K 热度指数：353828
 *
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *
 * @author Zer01ne
 * @since 2019/3/13 23:22
 */
public class 数值的整数次方 {

    public static void main(String[] args) {
        System.out.println(Power(2, 8));
    }

    public static double Power(double base, int exponent) {
        if (exponent == 1){
            return base;
        }

        double num = 1;

        if (exponent % 2 == 0){
            exponent = exponent / 2;
        }else {
            exponent = (exponent - 1) / 2;
            num = base;
        }

        while (exponent != 0){
            num = base * base * num;
            exponent--;
        }

        return num;
    }
}
