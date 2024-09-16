package com.darkquantum.xiaomistore.manage.api;

import com.darkquantum.xiaomistore.common.model.Favorite;
import com.darkquantum.xiaomistore.common.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/favorite")
public class FavoriteApi extends BaseApi<Favorite>{
    private FavoriteService service;
    @Autowired
    public void setFavoriteService(FavoriteService service) {
        this.service = service;
    }
}
