package com.github.basic;

import java.io.*;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/13 16:02
 */
public class IOBufferReadTest {

    public static void main(String[] args) throws IOException {


        FileInputStream stream = new FileInputStream("F:\\分布式事务-总结.mp4");

        byte[] buffer = new byte[1024 * 1024 * 30];
        //byte[] buffer = new byte[512];

        int read = 0;


        long begin = System.currentTimeMillis();

        while ((stream.read(buffer)) != -1){
            continue;
        }

        long end = System.currentTimeMillis();

        System.out.println(end - begin);

    }
}
