package com.github.io.bio;

import com.github.io.ServerProperties;
import com.github.utils.io.InputUtil;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * BIO客户端
 * @Author: Zer01ne
 * @Date: 2019/3/1 10:14
 * @Version 1.0
 */
public class BioClient {

    public static void main(String[] args) {

        Socket client = null;
        Scanner reader = null;
        PrintStream writer = null;
        boolean flag = true;

        try {
            client = new Socket(ServerProperties.HOST_NAME,ServerProperties.HOST_PORT);
            System.out.println("已经成功的连接到了服务器端，可以进行消息的发送处理。");
            reader = new Scanner(client.getInputStream());
            //默认情况下scanner分割符是空格，只要scanner扫描遇到的数据符合这个正则表达式，前面的就当一个数据就可以用Scanner中的next()返回取得数据。
            reader.useDelimiter("\n");
            writer = new PrintStream(client.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }



        while(flag){

            String str = InputUtil.getString("请输入内容：");

            writer.println(str);

            if ("quit".equalsIgnoreCase(str)){
                flag = false;
            }

            if (reader.hasNext()){
                String returnVal = reader.next();
                System.out.println(returnVal);
            }

        }
    }
}
