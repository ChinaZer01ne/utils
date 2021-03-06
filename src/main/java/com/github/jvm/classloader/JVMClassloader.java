package com.github.jvm.classloader;

/**
 * @Author: Zer01ne
 * @Date: 2019/2/28 14:29
 * @Version 1.0
 */
class Member{

}

public class JVMClassloader {
    public static void main(String[] args) {

        //String类是个系统类，系统类的类加载期是不同的
        //静态常量池定义
        String str = "Hello";
        Member member = new Member();
        System.out.println(str.getClass().getClassLoader());
        System.out.println(member.getClass().getClassLoader());
        //jdk1.8之前是ext类加载期，jdk1.9之后是platform类加载器
        System.out.println(member.getClass().getClassLoader().getParent());
        System.out.println(member.getClass().getClassLoader().getParent().getParent());
    }
}
