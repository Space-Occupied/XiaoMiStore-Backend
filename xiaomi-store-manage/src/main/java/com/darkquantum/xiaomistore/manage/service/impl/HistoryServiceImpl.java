package com.darkquantum.xiaomistore.manage.service.impl;

import com.darkquantum.xiaomistore.common.model.History;
import com.darkquantum.xiaomistore.common.service.HistoryService;
import com.darkquantum.xiaomistore.manage.dao.HistoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryServiceImpl extends BaseServiceImpl<History> implements HistoryService {
    private HistoryDao dao;
    @Autowired
    public void setHistoryDao(HistoryDao dao) {
        this.dao = dao;
    }
}
