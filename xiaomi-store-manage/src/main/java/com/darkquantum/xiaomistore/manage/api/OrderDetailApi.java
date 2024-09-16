package com.darkquantum.xiaomistore.manage.api;

import com.darkquantum.xiaomistore.common.model.OrderDetail;
import com.darkquantum.xiaomistore.common.service.OrderDetailService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orderDetail")
public class OrderDetailApi extends BaseApi<OrderDetail>{
    @DubboReference(id = "orderDetailService")
    private OrderDetailService service;
}
