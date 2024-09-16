package com.darkquantum.xiaomistore.manage.service.impl;

import com.darkquantum.xiaomistore.common.model.Cart;
import com.darkquantum.xiaomistore.common.service.CartService;
import com.darkquantum.xiaomistore.manage.dao.CartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl extends BaseServiceImpl<Cart> implements CartService {
    private CartDao dao;
    @Autowired
    public void setCartDao(CartDao dao) {
        this.dao = dao;
    }
}
