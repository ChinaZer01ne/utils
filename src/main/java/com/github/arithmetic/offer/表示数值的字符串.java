package com.github.arithmetic.offer;

/**
 *
 * 表示数值的字符串
 * 时间限制：1秒 空间限制：32768K 热度指数：147198
 * 本题知识点： 字符串
 *  算法知识视频讲解
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/11 16:31
 */
public class 表示数值的字符串 {

    public boolean isNumeric(char[] str) {
        // 标记符号、小数点、e是否出现过
        boolean hasSymbol = false;
        boolean hasPoint = false;
        boolean hasE = false;

        for (int i = 0; i < str.length; i++) {
           if (str[i] == 'E' || str[i] == 'e'){
               if (i == str.length - 1){
                   return false;  // e后面一定要接数字
               }
               if (hasE){
                   return false;    // 不能同时存在两个e
               }
               hasE = true;
           }else if (str[i] == '+' || str[i] == '-'){
               //第二次出现‘+’‘-’，必须在e后面
               if (hasSymbol && str[i - 1] != 'e' && str[i - 1] != 'E'){
                   return false;
               }
               // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
               if (!hasSymbol && i > 0 &&  str[i - 1] != 'e' && str[i - 1] != 'E'){
                   return false;
               }
               hasSymbol = true;
           }else if (str[i] == '.') {
               // 有e不能有小数点，小数点不能出现两次
               if (hasE || hasPoint){
                   return false;
               }

               hasPoint = true;
           }else if (str[i] < '0' || str[i] > '9'){
               return false;
           }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
