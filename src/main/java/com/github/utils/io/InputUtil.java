package com.github.utils.io;

import org.junit.platform.commons.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtil {
    //从键盘中读
    private static final BufferedReader KEYWORD_INPUT = new BufferedReader(new InputStreamReader(System.in));

    private InputUtil(){}

    public static String getString(String pormpt){
        String str = null;
        boolean flag = true;
        while(flag){
            System.out.println(pormpt);
            try {
                str = KEYWORD_INPUT.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (StringUtils.isBlank(str)){
                System.out.println("输入不能为空！请重新输入：");
            }else if ("quit".equalsIgnoreCase(str)){
                flag = false;
            }
        }
        return str;
    }
}
