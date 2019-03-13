package com.github.arithmetic.offer;
/**
 * 【第二题】
 *
 * 替换空格
 *
 * 时间限制：1秒 空间限制：32768K 热度指数：850997
 *
 * 本题知识点： 字符串
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author Zer01ne
 * @since 2019/3/12 21:25
 */
public class 替换空格 {

    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer("hello world");
        System.out.println(replaceSpace(stringBuffer));
    }

    public static String replaceSpace(StringBuffer str) {

        char[] chars = str.toString().toCharArray();
        StringBuffer stringBuffer = new StringBuffer();

        for (char c:
             chars) {
            if (" ".toCharArray()[0] == c){
                stringBuffer.append("%20");
            }else {
                stringBuffer.append(c);
            }
        }
        return stringBuffer.toString();
    }
}
