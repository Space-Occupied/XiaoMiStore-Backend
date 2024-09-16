package com.darkquantum.xiaomistore.manage.api;

import com.darkquantum.xiaomistore.common.model.Order;
import com.darkquantum.xiaomistore.common.service.OrderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderApi extends BaseApi<Order>{
    @DubboReference(id = "orderService")
    private OrderService service;
}
