package com.github.utils.file;

import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RecursiveTask;

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
    public static List<File> traversal(String path){
        List<File> fileList = new ArrayList<>();
        File file = new File(path);

        if (!file.exists()){
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        File[] files = file.listFiles();

        if (files == null || files.length == 0){
            return null;
        }

        for (File fileItem:
             files) {
            if (fileItem.isDirectory()){
                List<File> childFiles = traversal(fileItem.getPath());
                if (childFiles != null){
                    fileList.addAll(childFiles);
                }
            }else {
                fileList.add(fileItem);
            }
        }

        return fileList;

    }

    /**
     * 遍历文件，广度优先
     * @return void
     * @throws
     */
    public static List<File> traversal2(String path){
        List<File> fileList = new ArrayList<>();
        File file = new File(path);

        if (!file.exists()){
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        Queue<File> queue = new LinkedList<>();
        queue.add(file);

        while (!queue.isEmpty()){
            File root = queue.poll();

            if (root == null){
                continue;
            }

            if (root.isDirectory()){


                File[] files = root.listFiles();
                if (files == null || files.length == 0){
                    continue;
                }

                List<File> curFiles = Arrays.asList(files);

                queue.addAll(curFiles);
            }else {

                fileList.add(root);
            }

        }

        return fileList;

    }



}
