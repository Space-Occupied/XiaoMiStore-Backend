package com.darkquantum.xiaomistore.user.controller;

import com.darkquantum.xiaomistore.common.model.CartInfo;
import com.darkquantum.xiaomistore.common.model.PurchaseInfo;
import com.darkquantum.xiaomistore.user.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users/cart")
public class CartController {
    private CartService cartService;
    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/query")
    public List<CartInfo> queryCartByUsername(@RequestBody Map<String, String> params) {
        if(params == null || params.get("id") == null || params.get("id").isEmpty()) {
            return null;
        }
        return cartService.findByUsername(params.get("id"));
    }

    @PostMapping("/add")
    public Map<String, Object> addToCart(@RequestBody Map<String, Object> params) {
        boolean success;
        try{
            success = cartService.addToCart((String) params.get("id"),
                    Long.parseLong(params.get("pid").toString()),
                    Integer.parseInt(params.get("quantity").toString()),
                    params.get("pname").toString(),
                    (Map<String, Object>) params.get("mychoices"));
        }catch (Exception e) {
            return Map.of("ok", false);
        }
        return Map.of("ok", success);
    }

    @PostMapping("/purchase")
    public Map<String, Object> purchaseCart(@RequestBody PurchaseInfo info) {
        return cartService.purchase(info);
    }

    @PostMapping("/remove")
    public Map<String, Object> removeFromCart(@RequestBody Map<String, Object> params) {
        boolean success = cartService.deleteById(Long.parseLong(params.get("cart_id").toString()));
        return Map.of("ok", success);
    }

    @PostMapping("/modifyQuantity")
    public Map<String, Object> modifyQuantity(@RequestBody Map<String, Object> params) {
        boolean success = cartService.modifyQuantity(Long.parseLong(params.get("cart_id").toString()),
                Integer.parseInt(params.get("quantity").toString()));
        return Map.of("ok", success);
    }
}
