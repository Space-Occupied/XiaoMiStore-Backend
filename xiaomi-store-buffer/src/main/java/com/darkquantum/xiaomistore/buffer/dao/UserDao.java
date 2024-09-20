package com.darkquantum.xiaomistore.buffer.dao;

import com.darkquantum.xiaomistore.common.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User getUserByUsername(String username);
    User getUserById(Long id);
    String getPasswordByUsername(String username);
}
