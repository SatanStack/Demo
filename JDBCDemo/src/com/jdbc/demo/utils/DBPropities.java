package com.jdbc.demo.utils;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * 配置文件读取的工具类
 */
public class DBPropities {
    //单例设计模式，懒汉式
    private static DBPropities mDBPropities =null;
    private Properties mProperties = new Properties();
    private String driver = null;
    private String url = null;
    private String user =null;
    private String password = null;

    /**
     * 单例设计模式：构造行数私有化
     */
    private DBPropities(){
        initPropities();
        this.driver=mProperties.getProperty("driver");
        this.url=mProperties.getProperty("url");
        this.user=mProperties.getProperty("user");
        this.password=mProperties.getProperty("password");
    }

    /**
     * 初始化propities
     */
    public void initPropities(){
        try {
            mProperties.load(this.getClass().getClassLoader().getResourceAsStream("mysql.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 单例设计模式：获得DBPropities的方法
     * @return DBPropities的实例。
     */
    public static DBPropities getInstance(){

        if(mDBPropities == null){
            synchronized (DBPropities.class){
                if (mDBPropities == null){
                    mDBPropities = new DBPropities();
                }
            }
        }
        return mDBPropities;
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
