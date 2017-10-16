package com.jdbc.demo.dao;
import com.jdbc.demo.bean.User;
import java.util.List;

public interface UserDao {
    /**
     *
     * @param mUser
     */
    public void add(User mUser);

    /**
     *
     * @param id
     */
    public void delete(int id);

    /**
     *
     * @param id
     * @return
     */
    public User get(int id);

    /**
     *
     * @param mUser
     */
    public void update(User mUser);

    /**
     * 查询
     * @return
     */
    public List list();
}
