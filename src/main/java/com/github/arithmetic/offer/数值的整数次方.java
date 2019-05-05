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

        boolean nav = false;

        if (exponent < 0){
            if (base == 0){
                throw new RuntimeException("分母不能为0");
            }
            exponent = -exponent;
            nav = true;
        }else if (exponent == 0){
            return 1;
        }

        double res = 1;
        //根据位数的权值来算
        while (exponent != 0){
            if ((exponent&1) == 1){
                res *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return nav ? 1/res : res;
    }

    public static double Power2(double base, int exponent) {

        boolean nav = false;

        if (exponent < 0){
            if (base == 0){
                throw new RuntimeException("分母不能为0");
            }
            exponent = -exponent;
            nav = true;
        }

        double num = 1;

        for (int i = 0; i < exponent; i++) {
            num = num * base;
        }

        if (nav){
            return 1/num;
        }
        return num;
    }
}
