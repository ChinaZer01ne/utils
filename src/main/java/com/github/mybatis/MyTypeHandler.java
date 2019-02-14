package com.github.mybatis;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义Mybatis类型转换器
 * @Author: Zer01ne
 * @Date: 2019/2/11 15:02
 * @Version 1.0
 */

public class MyTypeHandler implements TypeHandler {
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, Object o, JdbcType jdbcType) throws SQLException {
        if (o == null){
            preparedStatement.setInt(i,0);
            return;
        }

        boolean flag = (Boolean)o;
        preparedStatement.setInt(i,flag ? 1 : 0);
    }

    @Override
    public Object getResult(ResultSet resultSet, String s) throws SQLException {
        int anInt = resultSet.getInt(s);
        if (anInt == 1){
            return true;
        }
        return false;
    }

    @Override
    public Object getResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public Object getResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
