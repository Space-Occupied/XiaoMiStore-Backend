package com.darkquantum.xiaomistore.user.service.impl;

import com.darkquantum.xiaomistore.common.model.User;
import com.darkquantum.xiaomistore.user.dao.UserDao;
import com.darkquantum.xiaomistore.user.model.UserInfoModify;
import com.darkquantum.xiaomistore.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Override
    public String getPasswordByUsername(String username) {
        return userDao.getPasswordByUsername(username);
    }

    @Override
    public Boolean modifyUser(UserInfoModify userInfoModify) {
        return userDao.modifyUser(userInfoModify);
    }
}
