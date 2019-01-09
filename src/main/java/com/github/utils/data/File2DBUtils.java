package com.github.utils.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.utils.db.DruidUtils;

import java.io.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static com.github.utils.data.QQPants.TYPE;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/4 10:29
 * @Version 1.0
 */
public abstract class File2DBUtils {

    private  ExecutorService service = Executors.newFixedThreadPool(10);
    private  AtomicInteger count = new AtomicInteger(1);

    public  List<String> file2DB(File dataFile,String charsetName,String delimiter) throws IOException {

        FileInputStream fis = new FileInputStream(dataFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis,charsetName));


        List<String> ignore = new ArrayList<>();
        DruidDataSource druid = DruidUtils.getDruid();
        String dataItem;
        while ((dataItem = reader.readLine()) != null){
            if (validAndConvert(dataItem) == null){
                continue;
            }
            if (!dataItem.contains(delimiter)){
                ignore.add(dataItem);
            }

            threadExecuteSQL(druid,dataItem,delimiter,ignore);
        }
        return ignore;
    }

    abstract String getSQL(String[] data);

    private  String validAndConvert(String dataItem){
        if (dataItem.contains("\\")){
            dataItem = dataItem.replaceAll("\\\\","\\\\\\\\");

        }
        if (dataItem.contains("/") || dataItem.contains("'")){
            dataItem = null;
        }
        return dataItem;
    }

    private List<String> threadExecuteSQL(DruidDataSource druid,String dataItem, String regex, List<String> ignore){

        String[] data = dataItem.split(regex);

        String sql = getSQL(data);

        service.submit(() -> {

            Connection connection = druid.getConnection();
            try {
                int num = connection.createStatement().executeUpdate(sql);
                String ps = num == 1 ? "成功" : "失败";

                boolean success = num == 1;
                if (!success) {
                    ignore.add(dataItem);
                }

                System.out.println(Thread.currentThread().getName() + "执行" + ps + "任务" + count.getAndIncrement());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                connection.close();
            }

            return null;
        });
        return ignore;
    }

    public static void main(String[] args) throws IOException {
        File2DBUtils file2DBUtils = new File2DBUtils() {
            @Override
            String getSQL(String[] data) {
                try {
                    data[0] = data[0].replace("@qq.com", "");
                    return  "insert into qq_data(username,password,type ) values('"+data[0]+"','"+ data[1]+"','"+TYPE+"')";
                }catch (Exception e){
                    return "";
                }

            }
        };

        List<String> ignore = file2DBUtils.file2DB(new File("F:\\BaiduNetdiskDownload\\100w_2.txt"), "gbk", "----");
        for (String str:
        ignore) {
            System.out.println(str);
        }
    }
}
