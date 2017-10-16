package com.jdbc.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC连接数据库的工具类
 */
public class DBUtil {

    /**
     * 获得数据库连接
     * @return 数据库连接实例
     */
    public static Connection getConnection(){
        Connection mConnection = null;
        //数据库配置文件实例
        DBPropities mDBPropities = DBPropities.getInstance();
        //驱动参数
        String driver = mDBPropities.getDriver();
        //数据库地址
        String url = mDBPropities.getUrl();
        //数据库账号
        String user = mDBPropities.getUser();
        //数据库密码
        String password = mDBPropities.getPassword();
        try {
            //加载数据库驱动
            Class.forName(driver);
            //获得数据库连接对象
            mConnection =DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return mConnection;
    }

    /**
     * 返回
     * @param mConnection
     * @param sql
     * @return
     */
    public static PreparedStatement getPreparedStatement(Connection mConnection,String sql){
        PreparedStatement mPreparedStatement = null;
        if (mConnection != null){
            try {
                mPreparedStatement = mConnection.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return mPreparedStatement;
    }

    /**
     * 关闭数据库连接的方法
     * @param mConnection
     */
    public static void closeConnection(Connection mConnection,PreparedStatement mPreparedStatement){
        if (mConnection != null && mPreparedStatement != null){
            try {
                mPreparedStatement.close();
                mConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                mPreparedStatement = null;
                mConnection = null;
            }
        }
    }
}
