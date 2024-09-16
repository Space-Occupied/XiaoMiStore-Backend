package com.darkquantum.xiaomistore.remote.service.impl;

import com.darkquantum.xiaomistore.common.model.Order;
import com.darkquantum.xiaomistore.common.service.OrderService;
import com.darkquantum.xiaomistore.remote.dao.OrderDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DubboService
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order> implements OrderService {
    private OrderDao dao;
    @Autowired
    public void setOrderDao(OrderDao dao) {
        this.dao = dao;
    }
}
