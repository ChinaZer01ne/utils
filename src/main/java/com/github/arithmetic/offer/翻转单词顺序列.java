package com.github.arithmetic.offer;

/**
 *
 * 翻转单词顺序列
 * 时间限制：1秒 空间限制：32768K 热度指数：306090
 * 本题知识点： 字符串
 *  算法知识视频讲解
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 *
 * @author Zer01ne
 * @version 1.0
 * @date 2019/5/17 11:28
 */
public class 翻转单词顺序列 {
    public static void main(String[] args) {
        翻转单词顺序列 a = new 翻转单词顺序列();
        System.out.println(a.ReverseSentence("   "));
    }

    /** 思路：对每个单词翻转然后整体翻转*/
    public String ReverseSentence(String str) {
        if (str.length() < 2 || str.trim().equals("")){
            return str;
        }

        String[] split = str.split(" ");

        for (int i = 0; i < split.length; i++) {
            split[i] =  ReverseSentenceProcess(split[i]);
        }
        String join = String.join(" ", split);
        return ReverseSentenceProcess(join);
    }

    public String ReverseSentenceProcess(String str) {
        if ("".equals(str)){
            return "";
        }
        return ReverseSentenceProcess(str.substring(1, str.length())) + str.substring(0,1);
    }
}
