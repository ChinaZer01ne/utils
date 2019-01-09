package com.github.utils.db;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @Author: Zer01ne
 * @Date: 2019/1/4 10:20
 * @Version 1.0
 */
public class DruidUtils {

    public static DruidDataSource getDruid(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        druidDataSource.setInitialSize(5);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxActive(10);
        return druidDataSource;
    }

    public static Connection getConnection() throws SQLException {
        DruidPooledConnection connection = getDruid().getConnection();
        connection.setAutoCommit(true);
        return connection;
    }

    public static PreparedStatement getStatement(String sql) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        return preparedStatement;
    }
}
