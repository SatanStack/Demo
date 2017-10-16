package com.jdbc.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC工具类，Statement实例
 */
public class DBUtils {

    /**
     * 获得数据库连接
     * @return 数据库连接
     */
    public  static Connection getConnection(){
        //数据库连接对象
        Connection mConnection = null;

        try {
            DBPropities mDBPropities = DBPropities.getInstance();
            String driver=mDBPropities.getDriver();
            String url=mDBPropities.getUrl();
            String user=mDBPropities.getUser();
            String password=mDBPropities.getPassword();
            Class.forName(driver);
            /**
             * jdbc:mysql://localhost:3306/huachuan
             * 协议:子协议://ip地址:端口号/数据库名称
             */
            mConnection = DriverManager.getConnection(url,user,password);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mConnection;
    }

    public  Statement getStatement(Connection mConnection){
        Statement mStatement = null;
        if (mConnection != null){

            try {
                mStatement = mConnection.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return mStatement;
    }

    /**
     * 关闭数据库连接
     * @param mConnection 数据库连接
     */
    public  void closeConnection(Connection mConnection){
        if (mConnection != null){
            try {
                mConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
