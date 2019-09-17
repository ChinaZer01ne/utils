package com.github.basic;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/9/16 11:35
 */
public class MoveTest {
    public static void main(String[] args) {

        Integer i = -255;
        System.out.println(Integer.toBinaryString(i));
        System.out.println(i >> 2);
        System.out.println(i >>> 2);
        System.out.println(Integer.toBinaryString(i >> 2));
        System.out.println(Integer.toBinaryString(i >>> 2));
        System.out.println("===================");
        System.out.println(Integer.toBinaryString(-12345));
        System.out.println(Integer.toBinaryString(53191));

    }
}
