package com.darkquantum.xiaomistore.user.controller;

import com.darkquantum.xiaomistore.user.model.Favorite;
import com.darkquantum.xiaomistore.user.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users/collection")
public class FavoriteController {
    private FavoriteService favoriteService;
    @Autowired
    public void setFavoriteService(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping("")
    public List<Favorite> getCollections(String uid) {
        return favoriteService.getFavoritesByUsername(uid);
    }

    @PostMapping("")
    public Map<String, Object> addCollection(@RequestBody Map<String, Object> params) {
        boolean success = favoriteService.addFavorite(Long.parseLong((String)params.get("pid")), (String)params.get("uid"));
        return Map.of("ok", success);
    }

    @PostMapping("/rm")
    public Map<String, Object> removeCollection(@RequestBody Map<String, Object> params) {
        boolean success = favoriteService.removeFavorite(Long.parseLong(params.get("pid").toString()), (String)params.get("uid"));
        return Map.of("ok", success);
    }
}
