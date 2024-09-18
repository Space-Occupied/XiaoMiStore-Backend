package com.darkquantum.xiaomistore.user.service;

import com.darkquantum.xiaomistore.user.model.Favorite;

import java.util.List;

public interface FavoriteService {
    List<Favorite> getFavoritesByUsername(String username);
    Boolean addFavorite(Long productId, String username);
    Boolean removeFavorite(Long productId, String username);
}
