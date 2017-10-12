package com.jdbc.demo.dao.impl;

import com.jdbc.demo.bean.User;
import com.jdbc.demo.dao.UserDao;
import com.jdbc.demo.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class UserDaoImpl implements UserDao {
    DBUtils mDBUtils = new DBUtils();

    @Override
    public void add(User mUser) {
        String sql = "insert int usertbl(name,password) valuse(?,?)";

        Connection mConnection = mDBUtils.getConnection();
        //PreparedStatement statement = mDBUtils.getStatement(mConnection);

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public void update(User mUser) {

    }

    @Override
    public List list() {
        return null;
    }
}
