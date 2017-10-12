package com.jdbc.demo.utils;

/**
 * @author satan
 * SQL语句的工具类
 */
public class SQLManager {
    /**
     * create table usertbl(id int(11) NOT NULL auto_increment,name varchar(20) DEFAULT NULL,
     * password varchar(20) DEFAULT NULL,PRIMARY KEY (`id`));
     **/
    public static final String CREATE_TABLE = "CREATE TABLE Usertbl ( id int(11) NOT NULL auto_increment,username varchar(20)" +
            "DEFAULT NULL, password varchar(20) DEFAULT NULL,PRIMARY KEY (`id`))";
    //增加的SQL语句
    public static final String ADD = "insert into  Usertbl (username,password) values('wangwu','130')";
    //修改数据
    public static final String UPDATE = "update Usertbl set username='bigtom' where id=1";
    //删除的SQL语句
    public static final String DELETE = "delete from Usertbl where id=4";
    //查询的语句
    public static final String QUERY = "select * from Usertbl";


}
