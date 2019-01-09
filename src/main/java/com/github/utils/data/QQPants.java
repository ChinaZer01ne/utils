package com.github.utils.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.github.utils.db.DruidUtils;

import java.io.*;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/3 13:37
 * @Version 1.0
 */
public class QQPants {

    private static final String PATH = "F:\\BaiduNetdiskDownload\\100w_1.txt";
    private static final String DELIMITER = "----";
    public static final String TYPE = "QQ";
    private static AtomicInteger count = new AtomicInteger(0);
    private static ExecutorService service = Executors.newFixedThreadPool(10);


    public static void main(String[] args) throws IOException, SQLException {

        String changePath;
        for (int i = 2; i < 200; i++) {
            changePath = "F:\\BaiduNetdiskDownload\\100w_"+i+".txt";

            BufferedReader reader;
            try {
                File dataFile = new File(changePath);
                FileInputStream fis = new FileInputStream(dataFile);
                reader = new BufferedReader(new InputStreamReader(fis,"gbk"));
            }catch (Exception e){
                continue;
            }


            DruidDataSource druid = DruidUtils.getDruid();

            String dataItem;
            while ((dataItem = reader.readLine()) != null){
                if (dataItem.contains(DELIMITER)){
                    if (dataItem.contains("/") || dataItem.contains("'")){
                        continue;
                    }
                    if (dataItem.contains("\\")){
                        dataItem = dataItem.replaceAll("\\\\","\\\\\\\\");

                    }
                    String[] data = dataItem.split(DELIMITER);
                    String sql;
                    if (data.length == 2){
                        data[0] = data[0].replace("@qq.com", "");
                        sql = "insert into qq_data(username,password,type ) values('"+data[0]+"','"+ data[1]+"','"+TYPE+"')";
                    }else if (data.length == 3){
                        sql = "insert into qq_data(username,password,ip,type ) values('"+data[0]+"','"+ data[1]+"','"+ data[2]+"','"+TYPE+"')";
                    }else if (data.length >= 4){
                        sql = "insert into qq_data(username,password,ip,address,type ) values('"+data[0]+"','"+ data[1]+"','"+ data[2]+"','"+ data[3]+"','"+TYPE+"')";
                    }else {
                        continue;
                    }



                    service.submit(() -> {

                        DruidPooledConnection connection = druid.getConnection();
                        connection.setAutoCommit(true);
                        try {
                            int num = connection.createStatement().executeUpdate(sql);
                            String ps = num == 1 ? "成功" : "失败";

                            boolean success = num == 1;
                            if (!success) {
                                System.err.println(data[0]);
                            }

                            System.out.println(Thread.currentThread().getName() + "执行" + ps + "任务" + count.getAndIncrement());
                        }catch (Exception e){
                            e.printStackTrace();
                            return null;
                        }finally {
                            connection.close();
                        }

                        return null;
                    });


                }
         }
      }
    }
}
