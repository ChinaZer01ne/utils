package com.github.io.aio;

import com.github.io.ServerProperties;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;


class ServerHandler implements CompletionHandler<Integer,ByteBuffer> {

    private AsynchronousSocketChannel socketChannel;
    private boolean flag = false;
    public ServerHandler(AsynchronousSocketChannel socketChannel){
        this.socketChannel = socketChannel;
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        //buffer.flip() ;
        String readMessage = new String(buffer.array(),0,buffer.remaining()).trim();
        String writeMessage = "from server " + readMessage;
        if ("quit".equalsIgnoreCase(writeMessage)){
            writeMessage = "再见了您内";
            flag = true;
        }
        this.write(writeMessage);
    }

    private void write(String writeMessage) {
        //ByteBuffer buffer = ByteBuffer.wrap(writeMessage.getBytes());
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(writeMessage.getBytes());
        buffer.flip() ;
        socketChannel.write(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer byteBuffer) {
                if (byteBuffer.hasRemaining()){
                    socketChannel.write(byteBuffer,byteBuffer,this);
                }else{
                    if (!ServerHandler.this.flag){
                        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                        ServerHandler.this.socketChannel.read(readBuffer,readBuffer,new ServerHandler(socketChannel));
                    }
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                try {
                    ServerHandler.this.socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void failed(Throwable exc, ByteBuffer buffer) {
        try {
            this.socketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/**
 * 连接的回调操作
 * @author Zer01ne
 * @since 2019/3/2 23:09
 */
class AioHandler implements CompletionHandler<AsynchronousSocketChannel,AioServerThread> {


    @Override
    public void completed(AsynchronousSocketChannel socketChannel, AioServerThread attachment) {
        attachment.getServerSocketChannel().accept(attachment,this);
        //创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        socketChannel.read(buffer,buffer,new ServerHandler(socketChannel));
    }

    @Override
    public void failed(Throwable exc, AioServerThread attachment) {
        System.out.println("客户端连接失败。。。");
        attachment.getCountDownLatch().countDown();

    }
}
/**
 * 服务器处理线程类
 * @author Zer01ne
 * @since 2019/3/2 22:48
 */
class AioServerThread implements Runnable{

    //异步管道
    AsynchronousServerSocketChannel serverSocketChannel = null;
    CountDownLatch countDownLatch = null;

    public AioServerThread() throws Exception{
        //打开通道
        serverSocketChannel = AsynchronousServerSocketChannel.open();
        //绑定端口
        serverSocketChannel.bind(new InetSocketAddress(ServerProperties.HOST_PORT));
        System.out.println("服务端已开启，监听端口：" + ServerProperties.HOST_PORT);
        countDownLatch = new CountDownLatch(1);
    }

    public AsynchronousServerSocketChannel getServerSocketChannel() {
        return serverSocketChannel;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    @Override
    public void run() {
        this.serverSocketChannel.accept(this,new AioHandler());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/**
 * Aio服务端
 * @author Zer01ne
 * @since 2019/3/2 22:48
 */
public class AioServer {
    public static void main(String[] args) throws Exception {

        new Thread(new AioServerThread()).start();

    }
}
