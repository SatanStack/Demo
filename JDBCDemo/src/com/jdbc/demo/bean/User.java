package com.jdbc.demo.bean;

/**
 * @author satan
 * 用户的实体类
 * 同意个业务用例，不同的表现方式
 */
public class User {
    /**
     * create table usertbl(id int(11) NOT NULL auto_increment,name varchar(20) DEFAULT NULL,
     * password varchar(20) DEFAULT NULL,PRIMARY KEY (`id`));
     */
    private int id;
    private String name;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
