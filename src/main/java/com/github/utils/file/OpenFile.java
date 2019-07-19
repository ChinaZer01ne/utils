package com.github.utils.file;

import com.alibaba.druid.sql.visitor.functions.If;
import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

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
    @Test
    public void createBigFile() throws IOException {

        File file = new File(PATH);

        if (!file.exists()){
            String dir = PATH.substring(0, PATH.lastIndexOf("\\"));
            File dirs = new File(dir);
            if (!dirs.exists()){
                dirs.mkdirs();
            }
            file.createNewFile();
        }

        FileOutputStream fileInputStream = new FileOutputStream(file);
        FileChannel channel = fileInputStream.getChannel();

        int size = 0;

        while (size < 1024 * 1024){
            int write = channel.write(ByteBuffer.wrap("test\n".getBytes()));
            size += write;
        }
    }
}
