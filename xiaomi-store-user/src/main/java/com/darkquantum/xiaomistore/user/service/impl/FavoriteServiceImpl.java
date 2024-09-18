package com.darkquantum.xiaomistore.user.service.impl;

import com.darkquantum.xiaomistore.common.model.User;
import com.darkquantum.xiaomistore.common.utils.SnowFlake;
import com.darkquantum.xiaomistore.user.dao.FavoriteDao;
import com.darkquantum.xiaomistore.user.dao.ProductDetailDao;
import com.darkquantum.xiaomistore.user.dao.UserDao;
import com.darkquantum.xiaomistore.user.model.Favorite;
import com.darkquantum.xiaomistore.user.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {
    private FavoriteDao favoriteDao;
    private ProductDetailDao productDetailDao;
    private UserDao userDao;
    private SnowFlake snowFlake;
    @Autowired
    public void setFavoriteDao(FavoriteDao favoriteDao) {
        this.favoriteDao = favoriteDao;
    }
    @Autowired
    public void setProductDetailDao(ProductDetailDao productDetailDao) {
        this.productDetailDao = productDetailDao;
    }
    @Autowired
    public void setSnowFlake(SnowFlake snowFlake) {
        this.snowFlake = snowFlake;
    }
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<Favorite> getFavoritesByUsername(String username) {
        List<Favorite> result = favoriteDao.getFavoritesByUsername(username);
        for (Favorite favorite : result) {
            favorite.setImg_path(productDetailDao.findCoverImage(favorite.getPid()));
        }
        return result;
    }

    @Override
    public Boolean addFavorite(Long productId, String username) {
        Long id = snowFlake.nextId();
        User user = userDao.getUserByUsername(username);
        return favoriteDao.addFavorite(id, productId, user.getId());
    }

    @Override
    public Boolean removeFavorite(Long productId, String username) {
        User user = userDao.getUserByUsername(username);
        return favoriteDao.removeFavorite(productId, user.getId());
    }
}
