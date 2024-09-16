package com.darkquantum.xiaomistore.manage.service.impl;

import com.darkquantum.xiaomistore.common.model.Admin;
import com.darkquantum.xiaomistore.common.service.AdminService;
import com.darkquantum.xiaomistore.manage.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService {
    private AdminDao dao;
    @Autowired
    public void setAdminDao(AdminDao dao) {
        this.dao = dao;
    }
}
