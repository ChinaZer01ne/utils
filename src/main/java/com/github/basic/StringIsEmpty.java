package com.github.basic;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: Zer01ne
 * @Date: 2019/3/15 17:21
 * @Version 1.0
 */
public class StringIsEmpty {
    public static void main(String[] args) {
        String  a = " ";
        String  b = "";
        String  c = null;

        System.out.println("是否为空" + StringUtils.isEmpty(a));
        System.out.println("是否为空" + StringUtils.isBlank(a));
        System.out.println("是否为空" + org.springframework.util.StringUtils.isEmpty(a));

        System.out.println("是否为空" + StringUtils.isEmpty(b));
        System.out.println("是否为空" + StringUtils.isBlank(b));
        System.out.println("是否为空" + org.springframework.util.StringUtils.isEmpty(b));

        System.out.println("是否为空" + StringUtils.isEmpty(b));
        System.out.println("是否为空" + StringUtils.isBlank(b));
        System.out.println("是否为空" + org.springframework.util.StringUtils.isEmpty(b));
    }
}
