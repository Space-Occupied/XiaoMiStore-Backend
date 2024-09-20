package com.darkquantum.xiaomistore.buffer.service.impl;

import com.darkquantum.xiaomistore.buffer.dao.CartDao;
import com.darkquantum.xiaomistore.buffer.dao.OrderDao;
import com.darkquantum.xiaomistore.buffer.dao.UserDao;
import com.darkquantum.xiaomistore.common.model.CartInfo;
import com.darkquantum.xiaomistore.common.model.CartItemSelection;
import com.darkquantum.xiaomistore.common.model.PurchaseInfo;
import com.darkquantum.xiaomistore.common.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl {
    private CartDao cartDao;
    private UserDao userDao;
    private OrderDao orderDao;
    @Autowired
    public void setCartDao(CartDao cartDao) {
        this.cartDao = cartDao;
    }
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @KafkaListener(topics = {"orders"})
    public void purchase(PurchaseInfo info) {
        User user = userDao.getUserByUsername(info.getOrder_client());
        info.setUser_id(user.getId());
        orderDao.addOrder(info);
        for (CartItemSelection selection : info.getCid_list()) {
            CartInfo cartInfo = findById(selection.getCid());
            orderDao.addOrderDetail(cartInfo, info.getId(), selection.getPrice());
            cartDao.deleteCart(selection.getCid());
        }
    }

    public CartInfo findById(Long id) {
        return cartDao.findById(id);
    }
}
