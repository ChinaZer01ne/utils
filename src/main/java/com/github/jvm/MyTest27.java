package com.github.jvm;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Zer01ne
 * @version 1.0
 * @date 2019/4/16 10:41
 */
public class MyTest27 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "root");
        System.out.println(connection);
    }
}
