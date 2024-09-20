package com.darkquantum.xiaomistore.user.service.impl;

import com.darkquantum.xiaomistore.common.model.User;
import com.darkquantum.xiaomistore.user.dao.OrderDao;
import com.darkquantum.xiaomistore.user.model.OrderInfo;
import com.darkquantum.xiaomistore.user.model.OrderInfoDetail;
import com.darkquantum.xiaomistore.user.service.OrderService;
import com.darkquantum.xiaomistore.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    private UserService userService;
    private OrderDao orderDao;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<OrderInfo> getOrderList(Long id) {
        return orderDao.getOrderList(id);
    }

    @Override
    public List<OrderInfoDetail> getOrderDetailList(Long id) {
        return orderDao.getOrderDetailList(id);
    }

    @Override
    public List<Map<String, Object>> getAllOrderInfo(String id) {
        User user = userService.getUserByUsername(id);
        List<Map<String, Object>> result = new ArrayList<>();
        List<OrderInfo> orderInfoList = getOrderList(user.getId());
        for (OrderInfo orderInfo : orderInfoList) {
            Map<String, Object> map = new HashMap<>();
            orderInfo.setOrder_client(id);
            map.put("order_info", orderInfo);
            List<OrderInfoDetail> orderInfoDetailList = getOrderDetailList(orderInfo.getOrder_id());
            for (OrderInfoDetail orderInfoDetail : orderInfoDetailList) {
                orderInfoDetail.setUid(id);
            }
            map.put("darr", orderInfoDetailList);
            result.add(map);
        }
        return result;
    }

    @Override
    public Map<String, Object> getAOrderInfo(Long id) {
        OrderInfo orderInfo = orderDao.getAOrder(id);
        if (orderInfo == null) {
            return Map.of("ok", false);
        }
        Map<String, Object> map = new HashMap<>();
        User user = userService.getUserById(orderInfo.getUid());
        orderInfo.setOrder_client(user.getUsername());
        map.put("order_info", orderInfo);
        List<OrderInfoDetail> orderInfoDetailList = getOrderDetailList(id);
        for (OrderInfoDetail orderInfoDetail : orderInfoDetailList) {
            orderInfoDetail.setUid(user.getUsername());
        }
        map.put("list", orderInfoDetailList);
        map.put("ok", true);
        return map;
    }

    @Override
    public Boolean removeOrder(Long id) {
        return orderDao.removeOrder(id);
    }
}
