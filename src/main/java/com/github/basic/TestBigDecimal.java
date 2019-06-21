package com.github.basic;

import java.math.BigDecimal;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/6/21 13:39
 */
public class TestBigDecimal {

    public static void main(String[] args) {

        //BigDecimal a = new BigDecimal("0.005");
        //BigDecimal b = new BigDecimal("1000000");
        BigDecimal a = new BigDecimal(0.005);
        BigDecimal b = new BigDecimal(1000000);
        System.out.println(a.multiply(b));
    }
}
