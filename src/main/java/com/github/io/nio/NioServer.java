package com.github.io.nio;

import com.github.io.ServerProperties;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Nio服务端
 * @Author: Zer01ne
 * @Date: 2019/3/1 13:07
 * @Version 1.0
 */
public class NioServer {

    public static void main(String[] args) throws IOException {
        //1、NIO考虑到性能问题，需要使用线程池
        ExecutorService service = Executors.newFixedThreadPool(5);
        //2、NIO的处理是基于Channel控制的，Selector管理所有的Channel
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //3、为其设置非阻塞的模式
        serverSocketChannel.configureBlocking(false);
        //4、服务器上需要提供一个网络的监听端口
        serverSocketChannel.bind(new InetSocketAddress(ServerProperties.HOST_PORT));
        //5、需要设置一个Selector，作为一个选择器，目的是管理所有的Channel
        Selector selector = Selector.open();
        //6、将当前的Channel注册到Selector选择器上
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        System.out.println("服务器已经启动成功，服务器监听的端口是：" + ServerProperties.HOST_PORT);
        //7、NIO采用的是轮询模式,每当用户连接的时候需要启动一个线程（线程池管理）
        int keySelect = 0;
        //实现轮询处理
        while ((keySelect = selector.select()) > 0){
            //获取全部的Channle状态
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            //遍历说所有的key
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                //请求连接状态
                if (selectionKey.isAcceptable()){
                    SocketChannel channel = serverSocketChannel.accept();
                    //处理
                    if (channel != null){
                        service.submit(new NioHandler(channel));
                    }
                }else if (selectionKey.isConnectable()){

                }else if (selectionKey.isReadable()){

                }else if (selectionKey.isWritable()){

                }
                iterator.remove();
            }
            //如果多个客户端连接，是不能关闭线程池和channel的
            //service.shutdown();
            //serverSocketChannel.close();
        }
    }

    private static class NioHandler implements Runnable{
        //客户端通道
        private SocketChannel channel;
        private boolean flag;

        private NioHandler(SocketChannel channel){
            this.channel = channel;
            flag = true;
        }


        @Override
        public void run() {
            //分配50个缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(50);
            try {
                while (this.flag){
                    //清空缓冲区
                    buffer.clear();
                    //从管道中读取数据
                    int readCount = 0;

                    readCount = this.channel.read(buffer);

                    String readMessage = new String(buffer.array(),0,readCount).trim();
                    //回应消息
                    String writeMessage = "from server :" + readMessage + "\n";

                    if ("quit".equalsIgnoreCase(readMessage)){
                        writeMessage = "bye......";
                        this.flag = false;
                    }
                    // 数据输入通过缓存形式完成，数据输出同样需要缓存操作。
                    //为了写入返回数据，需要清空缓冲区
                    buffer.clear();
                    buffer.put(writeMessage.getBytes());
                    //反转缓冲区（切换到写模式）
                    buffer.flip();
                    //回应数据
                    this.channel.write(buffer);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
