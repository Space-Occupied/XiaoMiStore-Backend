package com.darkquantum.xiaomistore.user.dao;

import com.darkquantum.xiaomistore.common.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User getUserByUsername(String username);
    String getPasswordByUsername(String username);
}
