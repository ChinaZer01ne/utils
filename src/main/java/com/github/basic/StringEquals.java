package com.github.basic;

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
}
