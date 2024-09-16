package com.darkquantum.xiaomistore.manage.service.impl;

import com.darkquantum.xiaomistore.common.model.Choice;
import com.darkquantum.xiaomistore.common.service.ChoiceService;
import com.darkquantum.xiaomistore.manage.dao.ChoiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChoiceServiceImpl extends BaseServiceImpl<Choice> implements ChoiceService {
    private ChoiceDao dao;
    @Autowired
    public void setChoiceDao(ChoiceDao dao) {
        this.dao = dao;
    }
}
