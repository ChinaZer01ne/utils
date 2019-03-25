package com.github.basic;

/**
 * @Author: Zer01ne
 * @Date: 2019/3/18 14:01
 * @Version 1.0
 */
public class BitwiseOperators {
    public static void main(String[] args) {
        int val = 16;
        /**
         * 补码计算
         *
         *  2 -> 0010
         *
         *  0010
         *  &
         *  1110
         *  =
         *  0010  -> 2
         *
         *  3 -> 0011
         *
         *  0011
         *  &
         *  1101
         *  =
         *  0001  -> 1
         *
         *  6 -> 0110
         *
         *  0110
         *  &
         *  1010
         *  =
         *  0010  -> 2
         *
         *
         *
         *  val & -val的结果：如果val是2的次方，返回本身；否则，如果是2的倍数返回2，否则如果是奇数返回1
         * */
        System.out.println(val & -val);

        System.out.println("======================");

        int[] array = new int[16];
        for (int i = 0; i < array.length; i++) {
            System.out.print(i & array.length - 1);
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            System.out.print(i % array.length);
        }
    }
}
