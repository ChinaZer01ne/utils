package com.github.arithmetic.coderreview;

/**
 *
 * 空格替换
 * 时间限制：3秒 空间限制：32768K 热度指数：34935
 * 本题知识点： 编程基础 数组 字符串
 *  算法知识视频讲解
 * 题目描述
 * 请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 *
 * 给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
 *
 * 测试样例：
 * "Mr John Smith”,13
 * 返回："Mr%20John%20Smith"
 * ”Hello  World”,12
 * 返回：”Hello%20%20World”
 *
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/5 15:59
 */
public class 空格替换 {

    public static String replaceSpace(String iniString, int length) {
        // write code here
        if (iniString == null || "".equals(iniString)){
            return iniString;
        }
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char c = iniString.charAt(i);
            if (c == ' '){
                stringBuilder.append("%20");
            }else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceSpace("Mr John Smith", 13));
    }
}
