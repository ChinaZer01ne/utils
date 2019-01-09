package com.github.utils.file;

import java.io.*;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/3 15:59
 * @Version 1.0
 */
public class OpenFile {

    public static final String PATH = "E:\\历次泄密门+常用弱口令字典集合\\1.txt";

    public static void main(String[] args) throws IOException {
        File file = new File(PATH);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        int lineNum = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null){
            System.out.println(line);
            lineNum++;
        }
    }
}
