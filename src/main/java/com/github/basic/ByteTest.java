package com.github.basic;

import io.netty.util.CharsetUtil;

import java.nio.charset.Charset;
import java.util.Arrays;

public class ByteTest {
    public static void main(String[] args) {
        String str = "50";
        System.out.println(Arrays.toString(str.getBytes(Charset.forName("utf-8"))));
        System.out.println(Arrays.toString(str.getBytes(Charset.forName("iso8859-1"))));
        System.out.println(Arrays.toString(str.getBytes(CharsetUtil.US_ASCII)));

        Data data = new Data();
        data.setType(5);
        data.setLength(10);
        data.setAge(18);
        data.setName("lion");

        //ByteBuf byteBuf = Unpooled.copiedBuffer(data);
        //ByteBufUtil.getBytes(data);
    }
}

class Data{
    private int type;
    private int length;
    private String name;
    private int age;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}