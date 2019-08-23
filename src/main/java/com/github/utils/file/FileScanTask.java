package com.github.utils.file;

import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/8/22 17:15
 */
public class FileScanTask extends RecursiveTask<List<File>> {


    public List<File> paths;
    public String path;

    public FileScanTask(List<File> paths){
        this.paths = paths;
    }

    public FileScanTask(String path){
        this.path = path;
        this.paths = new ArrayList<>();
        paths.add(new File(path));
    }

    @Override
    protected List<File> compute() {


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

        paths = Arrays.asList(files);

        if (CollectionUtils.isEmpty(paths)){
            return null;
        }



        for (int i = 0; i < files.length; i++) {

            File curFile = files[i];

            if (curFile.isDirectory()){

                FileScanTask aTask = null;
                FileScanTask bTask = null;

                List<File> list = Arrays.asList(curFile);


                aTask = new FileScanTask(list.subList(0,list.size() / 2));
                bTask = new FileScanTask(list.subList(list.size() / 2,list.size()));
                invokeAll(aTask,bTask);

                List<File> join = aTask.join();


                join.addAll(bTask.join());


                return join;
            }else {
                fileList.add(curFile);
            }
        }

        return fileList;

    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FileScanTask fileScanTask = new FileScanTask("C:\\");

        ForkJoinPool forkJoinPool = new ForkJoinPool(8);

        long t1 = System.currentTimeMillis();

        ForkJoinTask<List<File>> result = forkJoinPool.submit(fileScanTask);

        List<File> fileList = result.get();

        long t2 = System.currentTimeMillis();

        System.out.println(fileList.size());

        System.out.println(t2 - t1);
    }

}
