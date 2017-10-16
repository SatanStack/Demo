package com.jdbc.demo.dao.impl;

import com.jdbc.demo.bean.User;
import com.jdbc.demo.dao.UserDao;
import com.jdbc.demo.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void add(User mUser) {
        String sql = " insert into UserTbl (username,password)values(?,?) ";
        Connection mConnection = DBUtil.getConnection();
        PreparedStatement pstmt = DBUtil.getPreparedStatement(mConnection,sql);
        try {
            pstmt.setString(1,mUser.getName());
            pstmt.setString(2,mUser.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(mConnection,pstmt);
        }

    }

    @Override
    public void delete(int id) {
        String sql = " delet from UserTbl where id=？";
        Connection mConnection = DBUtil.getConnection();
        PreparedStatement pstmt = DBUtil.getPreparedStatement(mConnection,sql);
        try {
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(mConnection,pstmt);
        }

    }

    @Override
    public User get(int id) {

        User mUser = new User();
        String sql = " select id,username,password from UserTbl where id=? ";
        Connection mConnection = DBUtil.getConnection();
        PreparedStatement pstmt = DBUtil.getPreparedStatement(mConnection,sql);
        try {
            pstmt.setInt(1,id);
            ResultSet mResultSet = pstmt.executeQuery();
            while (mResultSet.next()){
               // mResultSet.getInt("id");
                String username = mResultSet.getString("username");
                String password = mResultSet.getString("password");
                mUser.setId(id);
                mUser.setName(username);
                mUser.setPassword(password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(mConnection,pstmt);
        }
        return mUser;
    }

    @Override
    public void update(User mUser) {
        String sql = " update UserTbl set username=?,pssword=? where id=? ";
        Connection mConnection = DBUtil.getConnection();
        PreparedStatement pstmt = DBUtil.getPreparedStatement(mConnection,sql);
        try {
            pstmt.setString(1,mUser.getName());
            pstmt.setString(2,mUser.getPassword());
            pstmt.setInt(3,mUser.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(mConnection,pstmt);
        }

    }

    /**
     * 查询所有的数据
     * @return
     */
    @Override
    public List list() {
        List<User> mList = new ArrayList<User>();
        String sql = " select id,username,password from UserTbl ";
        Connection mConnection = DBUtil.getConnection();
        PreparedStatement pstmt = DBUtil.getPreparedStatement(mConnection,sql);
        try {
            ResultSet mResultSet = pstmt.executeQuery();
            while (mResultSet.next()){
                User mUser = new User();
                mUser.setId(mResultSet.getInt("id"));
                mUser.setPassword(mResultSet.getString("password"));
                mUser.setName(mResultSet.getString("username"));
                mList.add(mUser);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(mConnection,pstmt);
        }


        return mList;
    }
}
