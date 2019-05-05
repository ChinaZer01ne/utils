package com.github.arithmetic.coderreview;

import java.util.Stack;

/**
 *
 * 合法括号序列判断
 * 时间限制：3秒 空间限制：32768K 热度指数：6283
 * 本题知识点： 编程基础 字符串
 *  算法知识视频讲解
 * 题目描述
 * 对于一个字符串，请设计一个算法，判断其是否为一个合法的括号串。
 *
 * 给定一个字符串A和它的长度n，请返回一个bool值代表它是否为一个合法的括号串。
 *
 * 测试样例：
 * "(()())",6
 * 返回：true
 * 测试样例：
 * "()a()()",7
 * 返回：false
 * 测试样例：
 * "()(()()",7
 * 返回：false
 *
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/5 11:55
 */
public class 合法括号序列 {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        if (A == null){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        char[] chars = A.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if ('(' == chars[i]){
                stack.push('(');
            }else if (')' == chars[i]){
                if (stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()){
            return true;
        }else {
            return false;
        }

    }
}
