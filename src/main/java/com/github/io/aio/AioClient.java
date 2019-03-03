package com.github.io.aio;

import com.github.io.ServerProperties;
import com.github.utils.io.InputUtil;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

class ClientReadHandler implements CompletionHandler<Integer,ByteBuffer> {

    private AsynchronousSocketChannel socketChannel ;
    private CountDownLatch countDownLatch ;
    public ClientReadHandler(AsynchronousSocketChannel clientChannel,CountDownLatch countDownLatch) {
        this.socketChannel = clientChannel ;
        this.countDownLatch = countDownLatch ;
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        //buffer.flip() ;
        String receiveMessage = new String(buffer.array(),0,buffer.remaining()) ;
        System.out.println(receiveMessage);
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.socketChannel.close();
        } catch (Exception e) {}
        this.countDownLatch.countDown();
    }
}

class ClientWriteHandler implements CompletionHandler<Integer,ByteBuffer>{

    private AsynchronousSocketChannel socketChannel;
    private CountDownLatch countDownLatch;

    public ClientWriteHandler(AsynchronousSocketChannel socketChannel, CountDownLatch countDownLatch) {
        this.socketChannel = socketChannel;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        if (buffer.hasRemaining()){
            //buffer.flip();
            this.socketChannel.write(buffer,buffer,this);
        }else {
            ByteBuffer readBuffer = ByteBuffer.allocate(1024);
            this.socketChannel.read(readBuffer,readBuffer,new ClientReadHandler(this.socketChannel,this.countDownLatch));
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.socketChannel.close();
        } catch (Exception e) {}
        this.countDownLatch.countDown();
    }
}

class AioClientThread implements Runnable{

    //异步管道
    private AsynchronousSocketChannel socketChannel = null;
    private CountDownLatch countDownLatch = null;

    public AioClientThread() throws IOException {
        socketChannel = AsynchronousSocketChannel.open();
        socketChannel.connect(new InetSocketAddress(ServerProperties.HOST_NAME,ServerProperties.HOST_PORT));
        countDownLatch = new CountDownLatch(1);
    }

    @Override
    public void run() {
        try {
            this.countDownLatch.await();
            this.socketChannel.close();
        } catch (Exception e) {}
    }

    public boolean sendMessage(String message){
        //ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        buffer.put(message.getBytes());
        buffer.flip();
        this.socketChannel.write(buffer,buffer,new ClientWriteHandler(this.socketChannel,this.countDownLatch));
        if ("quit".equalsIgnoreCase(message)){
            return false;
        }
        return true;
    }
}
public class AioClient {
    public static void main(String[] args) throws IOException {

        AioClientThread clientThread = new AioClientThread();
        new Thread(clientThread).start();

        while (clientThread.sendMessage(InputUtil.getString("请输入要发送的信息："))){

        }
    }
}
