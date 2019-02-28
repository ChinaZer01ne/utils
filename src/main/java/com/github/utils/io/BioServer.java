package com.github.utils.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BioServer {
    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8888);

        System.out.println("服务已启动，监听端口：8888");

        boolean flag = true;

        ExecutorService service = Executors.newFixedThreadPool(5);


        while (flag){
            Socket client = server.accept();
            service.submit(new BioClientHandler(client));
        }
        service.shutdown();
        server.close();

    }

    private static class BioClientHandler implements Runnable{

        private Socket client;
        private Scanner scanner;
        private PrintWriter writer;
        private boolean flag;

        public BioClientHandler(Socket client){
            this.client = client;
            flag = true;
            try {
                this.scanner = new Scanner(this.client.getInputStream());
                this.scanner.useDelimiter("\n");
                this.writer = new PrintWriter(this.client.getOutputStream());
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while (this.flag){

                if (this.scanner.hasNext()){
                    System.out.println(123123);
                    String val = this.scanner.next().trim();

                    if ("quit".equalsIgnoreCase(val)){
                        this.writer.print("bye....");
                        this.flag = false;
                    }else {

                        this.writer.print("返回：" + val);
                    }
                }
            }
            this.scanner.close();
            this.writer.close();
            try {
                this.client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
