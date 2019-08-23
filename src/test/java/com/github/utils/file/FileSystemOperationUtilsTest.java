package com.github.utils.file;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: Zer01ne
 * @Date: 2018/12/6 10:43
 * @Version 1.0
 */
public class FileSystemOperationUtilsTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        //List<File> traversal = FileSystemOperationUtils.traversal("C:\\");

        File file = new File("C:\\");
        ExecutorService service = Executors.newFixedThreadPool(8);
        List<File> fileList = Arrays.asList(file.listFiles());
        List<File> result = new ArrayList<>();
        CompletableFuture[] completableFutures = fileList.stream().map(file1 ->
                CompletableFuture.supplyAsync(() ->
                        FileSystemOperationUtils.traversal2(file1.getPath())).thenAccept(files -> {
                    System.out.println("文件数量："+files.size());
                    result.addAll(files);
                })).toArray(CompletableFuture[]::new);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
        int size = 0;
        for (CompletableFuture completableFuture : completableFutures) {
            List<File> fileList1 = (List<File>) completableFuture.get();
            size += fileList1.size();
        }
        System.out.println(size);
        System.out.println(result.size());
        long end2 = System.currentTimeMillis();
        System.out.println(end2-start);


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
