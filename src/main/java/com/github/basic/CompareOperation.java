package com.github.basic;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @Author: Zer01ne
 * @Date: 2019/3/29 11:13
 * @Version 1.0
 */
public class CompareOperation {
    public static void main(String[] args) {

        BigDecimal big = new BigDecimal(5);
        BigDecimal small = new BigDecimal(5);
        BigDecimal nullObject = null;

        if (big == null || small == null || Objects.compare(big,small,BigDecimal::compareTo) <= 0){
            System.out.println("big <= small is not right!");
        }else {
            System.out.println("big > small is right!");
        }
    }
}
