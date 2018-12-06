package com.github.utils.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 文件系统操作工具类
 * @Author: Zer01ne
 * @Date: 2018/12/6 10:35
 * @Version 1.0
 */
public class FileSystemOperationUtils {

    /**
     * 遍历文件
     * @return void
     * @throws
     */
    public static List traversal(String path){
        List<File> fileList = new ArrayList<>();
        File file = new File(path);

        File[] files = file.listFiles();
        for (File fileItem:
             files) {
            if (fileItem.isDirectory()){
                List<File> childFiles = traversal(fileItem.getPath());
                fileList.addAll(childFiles);
            }else {
                fileList.add(fileItem);
            }
        }

        return fileList;

    }
}
