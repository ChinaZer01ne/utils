package com.github.utils.file;


import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author: Zer01ne
 * @Date: 2018/12/6 10:43
 * @Version 1.0
 */
public class FileSystemOperationUtilsTest {

    //public static final String PATH = "/home/peach/GitProjects/notes/";
    public static final String PATH = "/usr/";

    @Test
    public void singleThreadRecursive(){
        long start = System.currentTimeMillis();
        List<File> traversal = FileSystemOperationUtils.traversal(PATH);
        long end = System.currentTimeMillis();
        System.out.println("单线程递归，文件数量：" + traversal.size());
        System.out.println("操作耗时： " + (end - start));
    }

    @Test
    public void singleThreadBFS(){
        long start = System.currentTimeMillis();
        List<File> traversal = FileSystemOperationUtils.traversal2(PATH);
        long end = System.currentTimeMillis();
        System.out.println("单线程广度遍历，文件数量：" + traversal.size());
        System.out.println("操作耗时： " + (end - start));
    }

    @Test
    public void multiThreadBFS(){
        long start = System.currentTimeMillis();
        File targetFile = new File(PATH);
        List<File> fileList = Arrays.asList(targetFile.listFiles());
        List<File> result = new CopyOnWriteArrayList<>();

        CompletableFuture[] completableFutures = fileList.stream().map(file ->
                CompletableFuture.supplyAsync(() ->
                        FileSystemOperationUtils.traversal2(file.getPath()))
                        .whenComplete((files, throwable) -> {
                            System.out.println("扫描到的文件数量： " + files.size());
                            result.addAll(files);
                        })
                        //.thenAccept(files -> {
                        //    result.addAll(files);
                        //})
        ).toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(completableFutures).join();
        long end = System.currentTimeMillis();

        System.out.println("多线程广度遍历，文件数量：" + result.size());
        System.out.println("操作耗时： " + (end - start));

    }

    @Test
    public void multiThreadRecursive(){
        long start = System.currentTimeMillis();
        File targetFile = new File(PATH);
        List<File> fileList = Arrays.asList(targetFile.listFiles());
        List<File> result = new CopyOnWriteArrayList<>();

        CompletableFuture[] completableFutures = fileList.stream().map(file ->
                        CompletableFuture.supplyAsync(() ->
                                FileSystemOperationUtils.traversal(file.getPath()))
                                .whenComplete((files, throwable) -> {
                                    System.out.println("扫描到的文件数量： " + files.size());
                                    result.addAll(files);
                                })
                //.thenAccept(files -> {
                //    result.addAll(files);
                //})
        ).toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(completableFutures).join();
        long end = System.currentTimeMillis();

        System.out.println("多线程递归遍历，文件数量：" + result.size());
        System.out.println("操作耗时： " + (end - start));

    }

    public static void main(String[] args) {
        //List<File> traversal = FileSystemOperationUtils.traversal2("C:\\");
        //List<String> traversal = FileSystemOperationUtils.traversal3("C:\\");
        //long end = System.currentTimeMillis();
        //System.out.println(traversal.size());
        //System.out.println(end-start);
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
