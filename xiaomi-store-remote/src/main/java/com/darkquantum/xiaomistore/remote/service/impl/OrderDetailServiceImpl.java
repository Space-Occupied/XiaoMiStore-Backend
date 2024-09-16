package com.darkquantum.xiaomistore.remote.service.impl;

import com.darkquantum.xiaomistore.common.model.OrderDetail;
import com.darkquantum.xiaomistore.common.service.OrderDetailService;
import com.darkquantum.xiaomistore.remote.dao.OrderDetailDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DubboService
@Service
public class OrderDetailServiceImpl extends BaseServiceImpl<OrderDetail> implements OrderDetailService {
    private OrderDetailDao dao;
    @Autowired
    public void setOrderDetailDao(OrderDetailDao dao) {
        this.dao = dao;
    }
}
