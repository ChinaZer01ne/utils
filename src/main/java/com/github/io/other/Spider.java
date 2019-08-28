package com.github.io.other;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/28 14:36
 */
public class Spider {

    private static byte[] request = null;

    static {
        StringBuffer temp = new StringBuffer();
        temp.append("GET http://192.168.2.123:8081/owl/index/queryindextop HTTP/1.1\r\n");
        temp.append("Host: 127.0.0.1:8080\r\n");
        temp.append("Connection: keep-alive\r\n");
        temp.append("Cache-Control: max-age=0\r\n");
        temp
                .append("User-Agent: Mozilla/5.0 (Windows NT 5.1) AppleWebKit/536.11 (KHTML, like Gecko) Chrome/20.0.1132.47 Safari/536.11\r\n");
        temp
                .append("Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\r\n");
        temp.append("Accept-Encoding: gzip,deflate,sdch\r\n");
        temp.append("Accept-Language: zh-CN,zh;q=0.8\r\n");
        temp.append("Accept-Charset: GBK,utf-8;q=0.7,*;q=0.3\r\n");
        temp.append("\r\n");
        request = temp.toString().getBytes();
    }
    public static void main(String[] args) throws IOException {

        SocketChannel channel = SocketChannel.open(new InetSocketAddress("192.168.2.123",8081));
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.write(ByteBuffer.wrap(request));
        int read = channel.read(buffer);

        while (read != -1){
            System.out.println(new String(buffer.array(),0,read).trim());
            buffer.clear();
            read = channel.read(buffer);
        }


    }
}
