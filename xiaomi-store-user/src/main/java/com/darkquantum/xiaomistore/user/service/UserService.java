package com.darkquantum.xiaomistore.user.service;

import com.darkquantum.xiaomistore.common.model.User;

public interface UserService {
    User getUserByUsername(String username);
    String getPasswordByUsername(String username);
}
