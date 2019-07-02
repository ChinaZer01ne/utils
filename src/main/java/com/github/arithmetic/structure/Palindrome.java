package com.github.arithmetic;

import org.hamcrest.core.Is;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 判断一个链表是不是回文结构(还得最原始的方法写一遍)
 * 因为链表查询是O（N）的，所以复杂度会高点，如果先把链表变成数组然后操作，应该会更好，不过这样空间复杂度又高了，用原始方法可以降下来
 * @Author: Zer01ne
 * @Date: 2019/1/17 16:38
 * @Version 1.0
 */
public class Palindrome {

    public static void main(String[] args) {
        LinkedList<Integer> data = new LinkedList<>();
        data.add(1);
        data.add(3);
        data.add(4);
        data.add(3);
        data.add(3);
        data.add(1);
        //isPalindrome(data);
        isPalindrome2(data);
    }

    //判断是否是回文结构(使用栈)
    private static void isPalindrome(LinkedList<Integer> data){
        Stack<Integer> stack = new Stack<>();
        int fast = 0;
        int slow = 0;

        while (fast < data.size()){
            fast = fast + 2;
            slow++;
        }

        while (slow < data.size()){
            stack.push(data.get(slow));
            slow++;
        }
        for (int i = 0; !stack.isEmpty(); i++) {
            if (!stack.pop().equals(data.get(i))){
                System.out.println("不是回文数");
                return;
            }
        }

        System.out.println("是回文数");
    }
    //判断是否是回文结构(不适用辅助空间)
    private static void isPalindrome2(LinkedList<Integer> data){
        int fast = 0;
        int slow = 0;
        int end = data.size() - 1;
        while (fast < data.size()){
            fast = fast + 2;
            slow++;
        }


        for (int i = 0; i < slow; i++) {
            if (!data.get(i).equals(data.get(end))){
                System.out.println("不是回文数");
                return;
            }
            end--;
        }
        System.out.println("是回文数");
    }
}
