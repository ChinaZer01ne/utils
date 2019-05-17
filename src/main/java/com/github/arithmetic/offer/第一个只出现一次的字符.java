package com.github.arithmetic.offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * 第一个只出现一次的字符
 * 时间限制：1秒 空间限制：32768K 热度指数：258933
 * 本题知识点： 字符串
 *  算法知识视频讲解
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/17 11:01
 */
public class 第一个只出现一次的字符 {

    public static void main(String[] args) {
        第一个只出现一次的字符 a = new 第一个只出现一次的字符();
        a.FirstNotRepeatingChar("google");
    }

    public int FirstNotRepeatingChar(String str) {
        //用linkedHashMap存储字符出现的次数
        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();

        for (int i = 0; i < str.length(); i++) {
            Integer time = linkedHashMap.get(str.charAt(i));
            if (time == null){
                time = 0;
            }
            linkedHashMap.put(str.charAt(i),time + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (linkedHashMap.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

}
