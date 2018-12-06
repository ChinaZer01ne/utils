package com.github.utils.file;

import sun.util.locale.StringTokenIterator;

import java.io.File;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: Zer01ne
 * @Date: 2018/12/6 10:43
 * @Version 1.0
 */
public class FileSystemOperationUtilsTest {
    public static void main(String[] args) {
        List<File> traversal = FileSystemOperationUtils.traversal("C:\\Users\\Ninee\\Desktop\\抖音合集56首.2018");

        for (File file:
             traversal) {
            String name = file.getName();

            int index = name.indexOf(".", name.indexOf(".") - 1 ) + 1;
            System.out.println(index);
            name = name.substring(index );
            file.renameTo(new File(file.getPath().substring(0,file.getPath().lastIndexOf("/") + 1) + name));
            System.out.println(name);
        }
    }
}
