package com.darkquantum.xiaomistore.user.dao;

import com.darkquantum.xiaomistore.user.model.CartChoice;
import com.darkquantum.xiaomistore.user.model.CartInfo;
import com.darkquantum.xiaomistore.user.model.CartInfoDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CartDao {
    CartInfoDetail findCartInfoDetail(Long id);//传入商品ID
    List<CartChoice> findCartChoiceList(Long id);//传入购物车ID
    List<CartInfo> findCartInfoByUser(Long id);//传入用户ID
    Boolean addToCart(@Param("id") Long id,@Param("uid") Long uid,@Param("pid") Long pid,@Param("quantity") Integer quantity,@Param("full_name") String fullName);
    Boolean addActionChoice(@Param("id") Long id, @Param("action_id") Long actionId, @Param("choice_id") Long choiceId);
    CartInfo findById(Long id);
    Boolean deleteCart(Long id);
    Boolean modifyQuantity(@Param("id") Long id, @Param("quantity") Integer quantity);
}
