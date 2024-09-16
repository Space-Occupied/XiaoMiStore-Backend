package com.darkquantum.xiaomistore.manage.service.impl;

import com.darkquantum.xiaomistore.manage.dao.UserDao;
import com.darkquantum.xiaomistore.common.model.User;
import com.darkquantum.xiaomistore.common.model.search.UserSearchBean;
import com.darkquantum.xiaomistore.common.service.UserService;
import com.darkquantum.xiaomistore.common.utils.PaginateInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.jasypt.util.password.PasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
    private UserDao dao;
    private final PasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();
    @Autowired
    public void setUserDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public boolean updateLastLogin(User user) {
        return dao.updateLastLogin(user);
    }

    @Override
    public boolean changePassword(User user) {
        return dao.changePassword(user);
    }

    @Override
    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public List<User> findByCondition(UserSearchBean usb, PaginateInfo pi) {
        try (Page<?> ignored = PageHelper.startPage(pi.getPageNo(), pi.getPageSize())) {
            return dao.findByCondition(usb);
        }
    }

    @Override
    public boolean save(User user) {
        user.setPassword(passwordEncryptor.encryptPassword(user.getPassword()));
        return dao.save(user);
    }
}
