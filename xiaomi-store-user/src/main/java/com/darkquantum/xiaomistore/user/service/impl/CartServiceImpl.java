package com.darkquantum.xiaomistore.user.service.impl;

import com.darkquantum.xiaomistore.common.model.*;
import com.darkquantum.xiaomistore.common.utils.SnowFlake;
import com.darkquantum.xiaomistore.user.dao.CartDao;
import com.darkquantum.xiaomistore.user.dao.OrderDao;
import com.darkquantum.xiaomistore.user.dao.ProductDetailDao;
import com.darkquantum.xiaomistore.user.dao.UserDao;
import com.darkquantum.xiaomistore.user.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImpl implements CartService {
    private CartDao cartDao;
    private UserDao userDao;
    private ProductDetailDao productDetailDao;
    private SnowFlake snowFlake;
    private KafkaTemplate<String, Object> kafkaTemplate;
    @Autowired
    public void setSnowFlake(SnowFlake snowFlake) {
        this.snowFlake = snowFlake;
    }
    @Autowired
    public void setCartDao(CartDao cartDao) {
        this.cartDao = cartDao;
    }
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Autowired
    public void setProductDetailDao(ProductDetailDao productDetailDao) {
        this.productDetailDao = productDetailDao;
    }
    @Autowired
    public void setKafkaTemplate(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public List<CartInfo> findByUsername(String name) {
        User user = userDao.getUserByUsername(name);
        List<CartInfo> result = cartDao.findCartInfoByUser(user.getId());
        for (CartInfo cartInfo : result) {
            cartInfo.setImg_cover(productDetailDao.findCoverImage(cartInfo.getPid()));
            BigDecimal price = cartInfo.getDetail().getMin_price();
            for (CartChoice choice : cartInfo.getChoices()) {
                price = price.add(choice.getPrice());
            }
            cartInfo.setPrice(price);
        }
        return result;
    }

    @Override
    public CartInfo findById(Long id) {
        return cartDao.findById(id);
    }

    @Override
    public Boolean deleteById(Long id) {
        return cartDao.deleteCart(id);
    }

    @Override
    public Boolean modifyQuantity(Long id, Integer quantity) {
        return cartDao.modifyQuantity(id, quantity);
    }

    @Override
    @Transactional
    public Boolean addToCart(String username, Long productId, Integer quantity, String productName, Map<String, Object> choices) {
        User user = userDao.getUserByUsername(username);
        long cartId = snowFlake.nextId();
        StringBuilder sb = new StringBuilder(productName);
        for (String key : choices.keySet()) {
            cartDao.addActionChoice(snowFlake.nextId(), cartId, Long.parseLong(((Map<String, Object>)choices.get(key)).get("cid").toString()));
            sb.append(" ").append(((Map<String, Object>)choices.get(key)).get("choice_name"));
        }
        return cartDao.addToCart(cartId, user.getId(), productId, quantity, sb.toString());
    }

    @Override
    @Transactional
    public Map<String, Object> purchase(PurchaseInfo info) {
//        User user = userDao.getUserByUsername(info.getOrder_client());
//        info.setUser_id(user.getId());
        info.setId(snowFlake.nextId());
        kafkaTemplate.send("orders", info);
//        orderDao.addOrder(info);
//        for (CartItemSelection selection : info.getCid_list()) {
//            CartInfo cartInfo = findById(selection.getCid());
//            orderDao.addOrderDetail(cartInfo, info.getId(), selection.getPrice());
//            cartDao.deleteCart(selection.getCid());
//        }
        return Map.of("ok", true, "order_id", info.getId());
    }

}
