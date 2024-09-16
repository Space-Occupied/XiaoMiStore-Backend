package com.darkquantum.xiaomistore.manage.api;

import com.darkquantum.xiaomistore.common.model.Cart;
import com.darkquantum.xiaomistore.common.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class CartApi extends BaseApi<Cart>{
    private CartService service;
    @Autowired
    public void setCartService(CartService service) {
        this.service = service;
    }
}
