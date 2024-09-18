package com.darkquantum.xiaomistore.user.dao;

import com.darkquantum.xiaomistore.user.model.Favorite;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FavoriteDao {
    List<Favorite> getFavoritesByUsername(String username);
    Boolean addFavorite(@Param("id") Long id, @Param("product_id") Long productId, @Param("user_id") Long userId);
    Boolean removeFavorite(@Param("product_id") Long productId, @Param("user_id") Long userId);
}
