package com.darkquantum.xiaomistore.manage.service.impl;

import com.darkquantum.xiaomistore.common.model.Favorite;
import com.darkquantum.xiaomistore.common.service.FavoriteService;
import com.darkquantum.xiaomistore.manage.dao.FavoriteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FavoriteServiceImpl extends BaseServiceImpl<Favorite> implements FavoriteService {
    private FavoriteDao dao;
    @Autowired
    public void setFavoriteDao(FavoriteDao dao) {
        this.dao = dao;
    }
}
