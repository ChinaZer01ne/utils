package com.github.utils.data;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.druid.proxy.DruidDriver;
import com.github.utils.db.DruidUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.io.*;
import java.sql.SQLException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/2 17:01
 * @Version 1.0
 */
public class Pants {

    private static final String PATH = "E:\\00.txt";
    private static final String DELIMITER = "----";
    public static final String TYPE = "12306";
    private static AtomicInteger count = new AtomicInteger(0);
    private static ExecutorService service = Executors.newFixedThreadPool(10);
    public static void main(String[] args) throws IOException{


        File dataFile = new File(PATH);
        FileInputStream fis = new FileInputStream(dataFile);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fis,"gbk"));

        DruidDataSource druid = DruidUtils.getDruid();

        String dataItem;
        while ((dataItem = reader.readLine()) != null){
            if (dataItem.contains(DELIMITER)){

                String[] data = dataItem.split(DELIMITER);

                String sql = "insert into 12306data(email,password,real_name,idcard,username,phone,email2,type ) values('"+data[0]+"','"+ data[1]+"','"+ data[2]+"','"+data[3]+"','"+data[4]+"','"+data[5]+"','"+data[6]+" ','"+TYPE+"'  )";


                service.submit(() -> {

                    DruidPooledConnection connection = druid.getConnection();
                    connection.setAutoCommit(true);
                    int num = connection.createStatement().executeUpdate(sql);
                    String ps = num == 1 ? "成功" : "失败";

                    boolean success = num == 1;
                    if (!success) {
                        System.err.println(data[0]);
                    }

                    System.out.println(Thread.currentThread().getName() + "执行" + ps + "任务" + count.getAndIncrement());
                    connection.close();
                    return null;
                });


            }
        }
    }




}
