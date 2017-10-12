package com.jdbc.demo.dao;

import com.jdbc.demo.bean.User;

import java.util.List;

public interface UserDao {
    public void add(User mUser);
    public void delete(int id);
    public User get(int id);
    public void update(User mUser);
    public List list();
}
