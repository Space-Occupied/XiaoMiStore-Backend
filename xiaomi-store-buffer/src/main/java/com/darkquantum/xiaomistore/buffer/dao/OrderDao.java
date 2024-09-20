package com.darkquantum.xiaomistore.buffer.dao;

import com.darkquantum.xiaomistore.common.model.CartInfo;
import com.darkquantum.xiaomistore.common.model.PurchaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface OrderDao {
    Boolean removeOrder(Long id);
    Boolean addOrder(PurchaseInfo purchaseInfo);
    Boolean addOrderDetail(CartInfo cartInfo, @Param("id") Long id, @Param("totalPrice") BigDecimal price);
}
