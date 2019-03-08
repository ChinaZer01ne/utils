package com.github.io.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

/**
 * Netty是基于NIO的框架的封装，和AIO没关系
 * 继承ChannelInboundHandlerAdapter，是对数据输入的处理
 */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        //当客户端连接成功之后会对此方法进行调用，可以给客户端发送一些消息
        byte[] data = "连接通道已开启，开始进行响应交互".getBytes();
        //NIO是基于缓存的操作，Netty也提供了一系列的缓存类（封装了NIO中的Buffer）
        ByteBuf buffer = Unpooled.buffer(data.length);
        //将数据写入缓存
        buffer.writeBytes(data);
        //发送
        ctx.writeAndFlush(buffer);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            //表示要进行数据信息的读取操作，对于读取操作完成后也可以直接回应
            //对于客户端发送来的数据，由于没有j进行指定数据类型，所以统一按照Object进行接收
            //默认类型 ByteBuf
            ByteBuf buf = (ByteBuf) msg;
            //在进行数据类型转换的过程中还可以进行编码指定
            String inputData = buf.toString(CharsetUtil.UTF_8);
            String returnData = "from server" + inputData;
            if ("quit".equalsIgnoreCase(inputData)){
                returnData = "bye...";
            }
            byte[] data = returnData.getBytes();
            //NIO是基于缓存的操作，Netty也提供了一系列的缓存类（封装了NIO中的Buffer）
            ByteBuf buffer = Unpooled.buffer(data.length);
            //将数据写入缓存
            buffer.writeBytes(data);
            //发送
            ctx.writeAndFlush(buffer);
        }finally {
            ReferenceCountUtil.release(msg);
        }

    }
}
