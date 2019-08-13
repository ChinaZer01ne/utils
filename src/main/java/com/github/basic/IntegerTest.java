package com.github.basic;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/28 9:51
 */
public class IntegerTest {


    public static void main(String[] args) {
        Integer num = 10;


        System.out.println(1000000000);

        System.out.println(1000000000 & -1000000000);


        //重要
        System.out.println(Integer.toString(10,2));

        System.out.println(Integer.parseInt("12345678"));

        System.out.println(Integer.valueOf("12345678"));

        System.out.println("=========================");
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toString(Integer.MAX_VALUE,2));
        System.out.println(Integer.toString(Integer.MAX_VALUE,2).length());
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.toString(Integer.MIN_VALUE,2));
        System.out.println(Integer.toString(Integer.MIN_VALUE,2).length());

        System.out.println(Integer.MIN_VALUE &  Integer.MAX_VALUE);

        System.out.println(Integer.toString(-10,2));
        System.out.println(Integer.toString(-10 & Integer.MAX_VALUE,2));

        System.out.println(Integer.toString(-1,2));
        System.out.println("=========================");
        System.out.println(-1 & 0x7fffffff);
        System.out.println(1 & 0x7fffffff);
        System.out.println("=========================");
        //输出给定数的十进制形式，第二个参数表示第一个参数是几进制
        System.out.println(Integer.parseInt("123456",8));
        System.out.println("=========================");
        //IntegerCache
        Integer a = 100;
        Integer b = 100;
        System.out.println(a == b);

        Integer c = 200;
        Integer d = 200;
        System.out.println(c == d);
        //自动装箱
        System.out.println(c == 200);

    }
}
