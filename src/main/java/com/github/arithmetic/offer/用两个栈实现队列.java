package com.github.arithmetic.offer;

import java.util.Stack;

/**
 * 【第五题】
 * 用两个栈实现队列
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：355472
 * 本题知识点： 队列 栈
 *
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @author Zer01ne
 * @since 2019/3/12 22:51
 */
public class 用两个栈实现队列 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {

        if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("Queue is empty!");
        }

        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {

    }
}
