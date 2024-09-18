package com.darkquantum.xiaomistore.user.service;

import com.darkquantum.xiaomistore.user.model.OrderInfo;
import com.darkquantum.xiaomistore.user.model.OrderInfoDetail;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<OrderInfo> getOrderList(Long id);
    List<OrderInfoDetail> getOrderDetailList(Long id);
    List<Map<String, Object>> getAllOrderInfo(String id);
    Map<String, Object> getAOrderInfo(Long id);
    Boolean removeOrder(Long id);
}
