package com.github.basic;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/7/11 15:25
 */
public class EqualsTest {
    public static void main(String[] args) {


        String a = "123";
        Integer b = 123;

        //不同类型之间是不能比较的   false
        System.out.println(a.equals(b));

        Byte c = 123;
        byte d = 123;

        System.out.println(c.equals(b));
        //System.out.println(c == b);
        System.out.println(d == b);

    }
}
