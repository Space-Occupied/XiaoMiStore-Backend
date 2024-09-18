package com.darkquantum.xiaomistore.user.dao;

import com.darkquantum.xiaomistore.common.model.User;
import com.darkquantum.xiaomistore.user.model.UserInfoModify;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User getUserByUsername(String username);
    User getUserById(Long id);
    String getPasswordByUsername(String username);
    Boolean modifyUser(UserInfoModify userInfoModify);
}
