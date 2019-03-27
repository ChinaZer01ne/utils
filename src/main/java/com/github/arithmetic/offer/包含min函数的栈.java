package com.github.arithmetic.offer;

import java.util.Stack;

/**
 * 【第17题】
 *
 * 包含min函数的栈
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：250043
 * 本题知识点： 栈
 *  算法知识视频讲解
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * @author Zer01ne
 * @since 2019/3/26 21:18
 */
public class 包含min函数的栈 {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {

        stack.push(node);

        if (minStack.size() != 0 && minStack.peek() < node){

            minStack.push(minStack.peek());
        }else {

            minStack.push(node);
        }
    }

    public int pop() {

        Integer ele = stack.pop();
        minStack.pop();
        return ele;
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        包含min函数的栈 stack = new 包含min函数的栈();
        stack.push(3);
        System.out.println(stack.min());
        stack.push(4);
        System.out.println(stack.min());
        stack.push(2);
        System.out.println(stack.min());
        stack.push(3);
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.pop();
        System.out.println(stack.min());
        stack.push(0);
        System.out.println(stack.min());
    }
}
