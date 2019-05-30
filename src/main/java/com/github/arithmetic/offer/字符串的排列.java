package com.github.arithmetic.offer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * 字符串的排列
 * 时间限制：1秒 空间限制：32768K 热度指数：373053
 * 本题知识点： 字符串
 *  算法知识视频讲解
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/6 16:21
 */
public class 字符串的排列 {

    public static void main(String[] args) {
        字符串的排列 p = new 字符串的排列();
        System.out.println(p.Permutation("abc").toString());
    }


    public ArrayList<String> Permutation(String str) {

        ArrayList<String> result = new ArrayList<>();


        if (str != null && str.length() > 0){
            PermutationHelper(str.toCharArray(), 0, result);
            Collections.sort(result);
        }

        return result;
    }
    /**
     * abcdef
     * a在第一位，后面全排列：a与a交换，后边全排列
     * a在第二位，后面全排列：a与b交换，后边全排列
     * a在第三位，后面全排列：a与c交换，后边全排列
     * a在第四位，后面全排列：a与d交换，后边全排列
     * a在第五位，后面全排列：a与e交换，后边全排列
     *
     * */
    private void PermutationHelper2(char[] chs, int cur, ArrayList<String> result) {
        if (cur == chs.length - 1){
            String s = String.valueOf(chs);
            if (!result.contains(s)){
                result.add(s);
            }
        }else {
            for (int i = cur; i < chs.length; i++) {
                swap(chs,i,cur);
                PermutationHelper2(chs,cur + 1,result);
                swap(chs,i,cur);
            }

        }




    }
    private void PermutationHelper(char[] chs, int cur, ArrayList<String> result) {

        if (cur == chs.length - 1){
            String s = String.valueOf(chs);
            if (!result.contains(s)){
                result.add(s);
            }
        }else {

            for (int j = cur; j < chs.length; j++) {
                swap(chs, cur, j);
                PermutationHelper(chs, cur+1, result);
                swap(chs, cur, j);
            }
        }

    }

    private void swap(char[] chars,int i,int j){
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
