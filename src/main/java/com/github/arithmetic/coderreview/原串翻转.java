package com.github.arithmetic.coderreview;

/**
 * 原串翻转
 * 时间限制：3秒 空间限制：32768K 热度指数：50265
 * 本题知识点： 编程基础 字符串
 *  算法知识视频讲解
 * 题目描述
 * 请实现一个算法，在不使用额外数据结构和储存空间的情况下，翻转一个给定的字符串(可以使用单个过程变量)。
 *
 * 给定一个string iniString，请返回一个string，为翻转后的字符串。保证字符串的长度小于等于5000。
 *
 * 测试样例：
 * "This is nowcoder"
 * 返回："redocwon si sihT"
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/5 15:44
 */
public class 原串翻转 {

    /** 思路：*/
    public static String reverseString(String iniString) {
        // write code here

        if ("".equals(iniString)){
            return "";
        }
        String lastString = iniString.substring(iniString.length() - 1);
        return lastString + reverseString(iniString.substring(0,iniString.length() - 1));
    }

    public static void main(String[] args) {
        System.out.println(reverseString("This is nowcoder"));
    }
}
