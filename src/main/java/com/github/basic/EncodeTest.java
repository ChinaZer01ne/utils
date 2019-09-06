package com.github.basic;

import java.io.UnsupportedEncodingException;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/9/6 9:44
 */
public class EncodeTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String gbk = new String("测试数据".getBytes(),"gbk");
        System.out.println(gbk);
    }
}
