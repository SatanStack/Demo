package com.jdbc.demo;

import com.jdbc.demo.utils.DBUtils;
import com.jdbc.demo.utils.SQLManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args){
        DBUtils mDBUtils = new DBUtils();
        /**
         * DDL:数据定义语言
         * 创建一个数据库表
         */
        //Test.operate(mDBUtils,SQLManager.ADD);
        //Test.update(mDBUtils,SQLManager.UPDATE);
        //Test.delet(mDBUtils,SQLManager.DELETE);
        Test.query(mDBUtils,SQLManager.QUERY);
    }


    /**
     * 操作数据库的方法
     * @param mDBUtils 工具类
     * @param sql 执行的sql语句
     */
    public static void operate(DBUtils mDBUtils,String sql){
        Connection mConnection = mDBUtils.getConnection();
        Statement mStatement = mDBUtils.getStatement(mConnection);
        try {
            mStatement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mDBUtils.closeConnection(mConnection);
        }
    }

    /**
     * 创建表的方法
     * @param mDBUtils 工具类
     * @param sql 执行的sql语句
     */
    public static void create (DBUtils mDBUtils,String sql){
        Connection mConnection = mDBUtils.getConnection();
        Statement mStatement = mDBUtils.getStatement(mConnection);
        try {
            mStatement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mDBUtils.closeConnection(mConnection);
        }
    }

    /**
     * 增加数据的方法
     */
    public static void add(DBUtils mDBUtils,String sql){
        Connection mConnection = mDBUtils.getConnection();
        Statement mStatement = mDBUtils.getStatement(mConnection);
        try {
            mStatement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mDBUtils.closeConnection(mConnection);
        }
    }

    /**
     * 更新数据的方法
     */
    public static void update(DBUtils mDBUtils,String sql){
        Connection mConnection = mDBUtils.getConnection();
        Statement mStatement = mDBUtils.getStatement(mConnection);
        try {
            mStatement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mDBUtils.closeConnection(mConnection);
        }
    }


    /**
     * 删除数据的方法
     */
    public static void delet(DBUtils mDBUtils,String sql){
        Connection mConnection = mDBUtils.getConnection();
        Statement mStatement = mDBUtils.getStatement(mConnection);
        try {
            mStatement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mDBUtils.closeConnection(mConnection);
        }
    }

    /**
     * 查询数据的方法
     */
    public static void query(DBUtils mDBUtils,String sql){
        Connection mConnection = mDBUtils.getConnection();
        Statement mStatement = mDBUtils.getStatement(mConnection);
        try {
            ResultSet mResultSet = mStatement.executeQuery(sql);
            while (mResultSet.next()){
                int id = mResultSet.getInt("id");
                String userName = mResultSet.getString("username");
                String password = mResultSet.getString("password");
                System.out.println("id:"+id+",username:"+userName+",password"+password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            mDBUtils.closeConnection(mConnection);
        }
    }

}
