package com.jdbc.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils {

    /**
     * 获得数据库连接
     * @return 数据库连接
     */
    public  Connection getConnection(){
        //数据库连接对象
        Connection mConnection = null;
        Properties mProperties = new Properties();
        String driver = null;
        String url = null;
        String user =null;
        String password = null;
        try {
            mProperties.load(this.getClass().getClassLoader().getResourceAsStream(
                    "mysql.properties"));
            //加载mysql驱动
            driver=mProperties.getProperty("driver");
            url=mProperties.getProperty("url");
            user=mProperties.getProperty("user");
            password=mProperties.getProperty("password");
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
