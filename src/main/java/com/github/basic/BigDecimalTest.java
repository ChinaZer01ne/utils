package com.github.basic;

import java.math.BigDecimal;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/21 13:39
 */
public class BigDecimalTest {

    public static void main(String[] args) {

        //BigDecimal a = new BigDecimal("0.005");
        //BigDecimal b = new BigDecimal("1000000");
        BigDecimal a = new BigDecimal(100.115);
        BigDecimal b = new BigDecimal(1000000);
        System.out.println(a.multiply(b));


        BigDecimal value = new BigDecimal("0.1");
        BigDecimal str = new BigDecimal(0.1);

        System.out.println("===================");

        System.out.println(new BigDecimal("0").equals(BigDecimal.ZERO));
        System.out.println(new BigDecimal("0.00").equals(BigDecimal.ZERO));

        System.out.println();
    }
}
