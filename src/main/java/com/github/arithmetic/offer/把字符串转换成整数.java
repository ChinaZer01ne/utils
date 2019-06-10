package com.github.arithmetic.offer;

/**
 *
 * 把字符串转换成整数
 * 时间限制：1秒 空间限制：32768K 热度指数：192929
 * 本题知识点： 字符串
 *  算法知识视频讲解
 *
 * 题目描述
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 *
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * 复制
 * +2147483647
 *     1a33
 * 输出
 * 复制
 * 2147483647
 *     0
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/10 16:48
 */
public class 把字符串转换成整数 {

    public static void main(String[] args) {
        把字符串转换成整数 a = new 把字符串转换成整数();
        //System.out.println(a.StrToInt("+123"));
        System.out.println(a.StrToInt("-2147483647"));
        int i = -2147483648;
    }

    /**
     *  0-9  对应ascii码  30-39
     * */
    public int StrToInt(String str) {

        if ("-2147483648".equals(str)){
            return Integer.MIN_VALUE;
        }

        char[] charArray = str.toCharArray();


        boolean isNative = false;
        boolean hasSymbol = false;
        //判断第一个字母是不是符号
        if (charArray.length > 0){
            if ("+".equals(String.valueOf(charArray[0]))){
                isNative = false;
                hasSymbol = true;
            }else if ("-".equals(String.valueOf(charArray[0]))){
                isNative = true;
                hasSymbol = true;
            }else if (charArray[0] < 48 || charArray[0] > 57){
                return 0;
            }
        }

        //第一个字母之后，验证合法性
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] < 48 || charArray[i] > 57){
                return 0;
            }
        }

        //字符串开头为0的情况
        boolean isZero = true;
        int cur = hasSymbol ? 1 : 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 0 && isZero){
                cur++;
                return 0;
            }else {
                isZero = false;
            }
        }
        //进行加权运算
        if (charArray.length - cur != 0){

            int result = 0;
            for (int i = cur; i < charArray.length; i++) {

                //解决范围越界问题
                if (result + (charArray[i] - 48) * Math.pow(10,charArray.length - 1 - cur) > Integer.MAX_VALUE){
                    return 0;
                }else {
                    result += (charArray[i] - 48) * Math.pow(10,charArray.length - 1 - cur);
                }
                cur++;
            }
            return isNative ? -result : result;

        }

        return 0;
    }
}
