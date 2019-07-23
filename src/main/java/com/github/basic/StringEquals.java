package com.github.basic;

import org.junit.Test;

public class StringEquals {
    public static void main(String[] args) {
        System.out.println(3 * 0.1);
        System.out.println(4 * 0.1);

        String text = new String("java");
        StringBuffer stringBuffer = new StringBuffer("java");
        re(text);
        re(stringBuffer);
        System.out.println(text+ stringBuffer);
    }

    private static void re(String text){
        text = text + "c";
    }

    private static void re(StringBuffer text){
        text = text.append("c");
    }

    @Test
    public void str(){
        //放入常量池
        String str = "java";
        //返回常量池的引用
        String intern = str.intern();
        //堆中创建对象并指向常量池中的引用
        StringBuffer stringBuffer = new StringBuffer("java");

        String str2 = "lion";
        StringBuffer stringBuffer2 = new StringBuffer("lion");
        String intern2 = str2.intern();


        System.out.println(intern == str);
        // stringBuffer.toString() 底层是new String()
        System.out.println(stringBuffer.toString() == stringBuffer.toString().intern());

        System.out.println(intern2 == str2);
        System.out.println(stringBuffer2.toString() == stringBuffer2.toString().intern());

    }

    @Test
    public void test(){
        String s1 = new String("hello ") + new String("world");
        s1.intern();
        String s2 = "hello world";
        System.out.println(s1 == s2);
    }
    @Test
    public void test2(){
        String s1 = new String("hello ") + new String("world");
        String s2 = "hello world";
        System.out.println(s1 == s2);
    }
}
