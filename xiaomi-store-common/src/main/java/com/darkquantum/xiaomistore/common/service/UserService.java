package com.darkquantum.xiaomistore.common.service;

import com.darkquantum.xiaomistore.common.model.User;
import com.darkquantum.xiaomistore.common.model.search.UserSearchBean;
import com.darkquantum.xiaomistore.common.utils.PaginateInfo;

import java.util.List;

public interface UserService extends BaseService<User> {
    boolean updateLastLogin(User user);

    boolean changePassword(User user);

    User findByUsername(String username);

    List<User> findByCondition(UserSearchBean usb, PaginateInfo pi);

}
