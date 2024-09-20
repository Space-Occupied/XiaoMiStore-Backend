package com.darkquantum.xiaomistore.user.service;

import com.darkquantum.xiaomistore.common.model.CartInfo;
import com.darkquantum.xiaomistore.common.model.PurchaseInfo;

import java.util.List;
import java.util.Map;

public interface CartService {
    List<CartInfo> findByUsername(String name);
    CartInfo findById(Long id);
    Boolean addToCart(String username, Long productId, Integer quantity, String productName, Map<String, Object> choices);
    Map<String, Object> purchase(PurchaseInfo info);
    Boolean deleteById(Long id);
    Boolean modifyQuantity(Long id, Integer quantity);
}
