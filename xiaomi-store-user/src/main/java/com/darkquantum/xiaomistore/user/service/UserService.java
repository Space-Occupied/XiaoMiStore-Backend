package com.darkquantum.xiaomistore.user.service;

import com.darkquantum.xiaomistore.common.model.User;
import com.darkquantum.xiaomistore.user.model.UserInfoModify;

public interface UserService {
    User getUserByUsername(String username);
    User getUserById(Long id);
    String getPasswordByUsername(String username);
    Boolean modifyUser(UserInfoModify userInfoModify);
}
