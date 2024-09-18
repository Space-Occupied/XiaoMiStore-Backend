package com.darkquantum.xiaomistore.user.dao;

import com.darkquantum.xiaomistore.user.model.CartInfo;
import com.darkquantum.xiaomistore.user.model.OrderInfo;
import com.darkquantum.xiaomistore.user.model.OrderInfoDetail;
import com.darkquantum.xiaomistore.user.model.PurchaseInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

@Mapper
public interface OrderDao {
    List<OrderInfo> getOrderList(Long id);
    List<OrderInfoDetail> getOrderDetailList(Long id);
    OrderInfo getAOrder(Long id);
    Boolean removeOrder(Long id);
    Boolean addOrder(PurchaseInfo purchaseInfo);
    Boolean addOrderDetail(CartInfo cartInfo, @Param("id") Long id, @Param("totalPrice") BigDecimal price);
}
