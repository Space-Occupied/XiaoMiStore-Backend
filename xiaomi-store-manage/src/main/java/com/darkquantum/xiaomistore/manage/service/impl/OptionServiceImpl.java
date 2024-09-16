package com.darkquantum.xiaomistore.manage.service.impl;

import com.darkquantum.xiaomistore.common.model.Option;
import com.darkquantum.xiaomistore.common.service.OptionService;
import com.darkquantum.xiaomistore.manage.dao.OptionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionServiceImpl extends BaseServiceImpl<Option> implements OptionService {
    private OptionDao dao;
    @Autowired
    public void setOptionDao(OptionDao dao) {
        this.dao = dao;
    }
}
