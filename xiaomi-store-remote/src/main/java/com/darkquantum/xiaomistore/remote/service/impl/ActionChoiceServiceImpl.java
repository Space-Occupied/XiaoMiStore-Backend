package com.darkquantum.xiaomistore.remote.service.impl;

import com.darkquantum.xiaomistore.common.model.ActionChoice;
import com.darkquantum.xiaomistore.common.service.ActionChoiceService;
import com.darkquantum.xiaomistore.remote.dao.ActionChoiceDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DubboService
@Service
public class ActionChoiceServiceImpl extends BaseServiceImpl<ActionChoice> implements ActionChoiceService {
    private ActionChoiceDao dao;
    @Autowired
    public void setActionChoiceDao(ActionChoiceDao dao) {
        this.dao = dao;
    }
}
