package com.github.arithmetic.offer;

import java.util.Stack;

/**
 *
 * 栈的压入、弹出序列    TODO
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：298043
 * 本题知识点： 栈
 *  算法知识视频讲解
 * 题目描述
 *
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 * @Author: Zer01ne
 * @Date: 2019/3/27 15:29
 * @Version 1.0
 */
public class 栈的压入弹出序列 {

    public static void main(String[] args) {
        int[] pushA = new int[]{1,2,3,4,5};
        int[] popA = new int[]{4,3,5,1,2};
        System.out.println(IsPopOrder(pushA, popA));
    }

    /** 思路：对入栈出栈操作进行模拟，然后比对
     *
     * 先执行压栈操作，判断当前站定和出栈序列的当前元素是否相等，如果相等则出栈操作，然后继续判断是否与出栈序列下一个元素相等，如果不相等，按照压栈序列继续压栈
     * */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {

        if (pushA.length == 0 || popA.length == 0){
            return false;
        }


        Stack<Integer> stack = new Stack<>();
        stack.push(pushA[0]);

        //出栈序列元素指针
        int popPoint = 0;
        //入栈序列元素指针
        int pushPoint = 1;


        //pushPoint <= pushA.length
        while (pushPoint <= pushA.length && popPoint < popA.length){
            if (stack.peek() != popA[popPoint]){
                //此时说明入栈完毕，栈中还有元素
                if (pushPoint == pushA.length){
                    return false;
                }
                stack.push(pushA[pushPoint]);
                pushPoint++;

            }else {
                stack.pop();
                popPoint++;
            }
        }


        return stack.isEmpty();

    }

}
