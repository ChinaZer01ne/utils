package com.github.io.nio;

import com.github.io.ServerProperties;
import com.github.utils.io.InputUtil;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * NIO客户端
 * @Author: Zer01ne
 * @Date: 2019/3/1 13:07
 * @Version 1.0
 */
public class NioClient {
    public static void main(String[] args) throws Exception {

        //打开客户端连接通道
        SocketChannel clientChannel = SocketChannel.open();
        //连接
        clientChannel.connect(new InetSocketAddress(ServerProperties.HOST_NAME,ServerProperties.HOST_PORT));
        //开辟缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(50);
        boolean flag = true;

        while (flag){
            //清空缓冲区
            buffer.clear();

            String inputData = InputUtil.getString("请输入要发送的内容：").trim();
            //将输入数据保存在缓存区之中（写到缓冲区）
            buffer.put(inputData.getBytes());
            //重置缓冲区
            buffer.flip();
            //发送数据内容（从buffer读，写到clientChannel）
            clientChannel.write(buffer);
            //在读取数据之前，清空缓冲区
            buffer.clear();
            int readCount = clientChannel.read(buffer);
            //buffer.flip();
            System.out.println(new String(buffer.array(),0,readCount));
            if ("quit".equalsIgnoreCase(inputData)){
                flag = false;
            }
        }
        clientChannel.close();
    }
}
