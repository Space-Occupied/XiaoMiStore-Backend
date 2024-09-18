package com.darkquantum.xiaomistore.user.controller;

import com.darkquantum.xiaomistore.user.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users/order")
public class OrderController {
    private OrderService orderService;
    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("")
    public Map<String, Object> getOrderList(String uid){
        return Map.of("ok", true, "list", orderService.getAllOrderInfo(uid));
    }

    @PostMapping("/query")
    public Map<String, Object> getAOrder(@RequestBody Map<String, Object> params){
        long id = paramsIdParse(params, "id");
        if(id < 0) {
            return Map.of("ok", false);
        }
        return orderService.getAOrderInfo(id);
    }

    @PostMapping("/remove")
    public Map<String, Object> removeOrder(@RequestBody Map<String, Object> params) {
        long id = paramsIdParse(params, "order_id");
        if(id < 0) {
            return Map.of("ok", false);
        }
        return Map.of("ok", orderService.removeOrder(id));
    }

    private Long paramsIdParse(Map<String, Object> params, String key){
        if (params.getOrDefault(key, null) == null) {
            return -1L;
        }
        long id;
        try {
            id = Long.parseLong(params.get(key).toString());
        }catch (Exception e) {
            return -1L;
        }
        return id;
    }
}
