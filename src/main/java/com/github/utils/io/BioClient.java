package com.github.utils.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class BioClient {
    public static void main(String[] args) {
        try {
            Socket client = new Socket("localhost",8888);
            // 获取服务端响应的数据
            Scanner scanner = new Scanner(client.getInputStream());
            scanner.useDelimiter("\n");
            PrintWriter writer = new PrintWriter(client.getOutputStream());
            boolean flag = true;
            while (flag){
                String inputData = InputUtil.getString("请输入要发送的内容：");
                writer.print(inputData);
                if (scanner.hasNext()){
                    String str = scanner.next().trim();
                    System.out.println(str);
                }
                if ("quit".equalsIgnoreCase(inputData)){
                    flag = false;
                }
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
