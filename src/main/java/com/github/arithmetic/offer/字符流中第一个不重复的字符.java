package com.github.arithmetic.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 字符流中第一个不重复的字符
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：123774
 * 本题知识点： 字符串
 *  算法知识视频讲解
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符
 *
 * @author Zer01ne
 * @since 2019/5/4 21:51
 */
public class 字符流中第一个不重复的字符 {

    static List<Character> list = new ArrayList<>();
    //Insert one char from stringstream
    public static void Insert(char ch)
    {
        if (list.contains(ch)){
            list.remove((Character)ch);
        }else {
            list.add(ch);
        }

    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce()
    {
        if (list.size() == 0){
            return '#';
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        // g g g # l l
        Insert('g');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('o');
        System.out.println(FirstAppearingOnce());
        Insert('g');
        System.out.println(FirstAppearingOnce());
        Insert('l');
        System.out.println(FirstAppearingOnce());
        Insert('e');
        System.out.println(FirstAppearingOnce());
    }
}
