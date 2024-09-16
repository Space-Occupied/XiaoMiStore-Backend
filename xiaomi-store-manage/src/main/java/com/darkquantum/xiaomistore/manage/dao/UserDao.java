package com.darkquantum.xiaomistore.manage.dao;

import com.darkquantum.xiaomistore.common.model.User;
import com.darkquantum.xiaomistore.common.model.search.UserSearchBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao extends BaseDao<User> {
    boolean changePassword(User user);

    User findByUsername(String username);

    List<User> findByCondition(UserSearchBean usb);

    boolean updateLastLogin(User user);
}
