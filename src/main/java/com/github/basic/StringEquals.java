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
    public void str(){//TODO 理解
        String str = "java";
        String intern = str.intern();
        StringBuffer stringBuffer = new StringBuffer("java");

        String str2 = "lion";
        String intern2 = str2.intern();
        StringBuffer stringBuffer2 = new StringBuffer("lion");


        System.out.println(intern == str);
        System.out.println(stringBuffer.toString() == stringBuffer.toString().intern());

        System.out.println(intern2 == str2);
        System.out.println(stringBuffer2.toString() == stringBuffer2.toString().intern());

    }
}
