package com.github.arithmetic.offer;

/**
 * 左旋转字符串
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：171601
 * 本题知识点： 字符串
 *  算法知识视频讲解
 * 题目描述
 *
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,
 * 要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * @author Zer01ne
 * @since 2019/3/27 22:00
 */
public class 左旋字符串 {

    public static void main(String[] args) {
        //System.out.println(RotateString("abcdef"));
        System.out.println("".substring(0,3));
        //System.out.println(RotateString("abc"));
        //System.out.println(RotateString("def"));
        //System.out.println(LeftRotateString("abcdef",3));
        //System.out.println("abcdef".substring(0,"abcdef".length() - 1));
    }
    /**
     * 思路：YX = (X反Y反)反
     * */
    public static String LeftRotateString(String str,int n) {
        if ("".equals(str)){
            return "";
        }
        return RotateString(RotateString(str.substring(0, n)) + RotateString(str.substring(n)));
    }

    private static String RotateString(String str){
        if ("".equals(str)){
            return "";
        }
        return str.substring(str.length() - 1) + RotateString(str.substring(0,str.length() - 1));
    }

    /**
     * 思路：str+=str，两个字符串拼接起来，然后再截取，如 helloworldhelloworld
     * */
}
