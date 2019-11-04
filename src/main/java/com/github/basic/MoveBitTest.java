package com.github.basic;


import java.util.Arrays;

public class MoveBitTest {
    public static void main(String[] args) {
        int i = 100;
        int j = -100;

        System.out.println(i << 1);
        System.out.println(j >> 1);
        System.out.println(i >>> 1);
        System.out.println(j >>> 1);

        System.out.println(isEquals(i, -j));

        System.out.println(convert2Bin(-10));
        System.out.println(Integer.toBinaryString(-10));
    }

    private static boolean isEquals(int i , int j){
        return (i ^ j) == 0;
    }


    private static String convert2Bin(int source){

        boolean nav = false;

        if (source < 0){
            source = - source;
            nav = true;
        }

        String result = "";
        int left = 0;

        while(source != 0){
            left = source % 2;
            source = source >> 1;
            result = left != 0 ?  1 + result :  0 + result;
        }

        if (nav){
            return reverseAddOne(result);
        }

        return result;
    }

    private static String reverseAddOne(String str) {
        char[] chars = str.toCharArray();
        // 按位取反
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0'){
                chars[i] = '1';
            }else if (chars[i] == '1'){
                chars[i] = '0';
            }
        }
        // 加1
        if (chars[chars.length - 1] == '0'){
            chars[chars.length - 1] = '1';
        }else {
            for (int i = chars.length - 1; i > 0; i--) {
                if (chars[i] == '0'){
                    chars[i] = '1';
                    break;
                }else if (chars[i] == '1') {
                    chars[i] = '0';
                }
            }
        }
        int i = 32 - new String(chars).length();
        // 前面拼1
        StringBuilder fill = new StringBuilder("");
        for (int j = 0; j < i; j++) {
            fill.append(1);
        }
        return fill.toString() + new String(chars);
    }
}