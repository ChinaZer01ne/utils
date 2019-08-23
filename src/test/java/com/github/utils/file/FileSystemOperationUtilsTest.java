package com.github.utils.file;


import java.io.File;
import java.util.List;

/**
 * @Author: Zer01ne
 * @Date: 2018/12/6 10:43
 * @Version 1.0
 */
public class FileSystemOperationUtilsTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        //List<File> traversal = FileSystemOperationUtils.traversal("C:\\");
        List<File> traversal = FileSystemOperationUtils.traversal2("C:\\");
        //List<String> traversal = FileSystemOperationUtils.traversal3("C:\\");
        long end = System.currentTimeMillis();
        System.out.println(traversal.size());
        System.out.println(end-start);
        //for (File file:
        //     traversal) {
        //    String name = file.getName();
        //
        //    int index = name.indexOf(".", name.indexOf(".") - 1 ) + 1;
        //    System.out.println(index);
        //    name = name.substring(index );
        //    file.renameTo(new File(file.getPath().substring(0,file.getPath().lastIndexOf("/") + 1) + name));
        //    System.out.println(name);
        //}
    }
}
