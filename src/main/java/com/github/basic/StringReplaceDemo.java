package com.github.basic;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/24 17:27
 */
public class StringReplaceDemo {

    public static void main(String[] args) {

        String str = "28:d2:44:29:40:f7 ";

        System.out.println(str.substring(0, 6));
        System.out.println(str.substring(11));


        long start = System.nanoTime();

        System.out.println(str.substring(0, 6) + "**:**" + str.substring(11));

        //char[] charArray = str.toCharArray();
        //charArray[6] = '*';
        //charArray[7] = '*';
        //charArray[9] = '*';
        //charArray[10] = '*';
        //System.out.println(charArray);

        long time = System.nanoTime() -start;
        System.err.println(time);
    }
}
