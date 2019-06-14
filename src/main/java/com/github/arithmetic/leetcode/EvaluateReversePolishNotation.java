package com.github.arithmetic.leetcode;

import java.util.Stack;

/**
 *
 * evaluate-reverse-polish-notation
 * 时间限制：1秒 空间限制：32768K 热度指数：88583
 * 本题知识点： 栈 leetcode
 *  算法知识视频讲解
 * 题目描述
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 *
 * Some examples:
 *
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/14 13:53
 */
public class EvaluateReversePolishNotation {

    public static void main(String[] args) {
        String[] test = new String[]{"0","3","/"};
        evalRPN(test);
    }

    /** 思路：很容易的方法：栈*/
    public static int evalRPN(String[] tokens) {

        if (tokens == null){
            return 0;
        }
        Stack<String> stack = new Stack<>();
        int a = 0;
        int b = 0;
        for (int i = 0; i < tokens.length; i++) {
            switch (tokens[i]){
                case "+":
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(b + a));
                    break;
                case "-":
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(b - a));
                    break;
                case "*":
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(b * a));
                    break;
                case "/":
                    a = Integer.parseInt(stack.pop());
                    b = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(b / a));
                    break;
                default:
                    stack.push(tokens[i]);
                    break;
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
