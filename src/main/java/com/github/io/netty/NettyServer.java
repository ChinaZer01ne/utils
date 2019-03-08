package com.github.io.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;

public class NettyServer {
    //服务端启动方法
    public void run(){
        //线程池是提升服务器性能的重要手段，利用定长的线程池可以保证核心线程的有效数量
        //在Netty中线程池的实现有两类：主线程池（接收客户端连接）、工作线程池（处理客户端连接）
        //创建主线程池
        EventLoopGroup bossGroup = new NioEventLoopGroup(5);
        //工作线程池
        EventLoopGroup workerGroup = new NioEventLoopGroup(10);
        //创建服务端NIO启动类，同时可以设置channel
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workerGroup);

    }

    public static void main(String[] args) {

    }
}
