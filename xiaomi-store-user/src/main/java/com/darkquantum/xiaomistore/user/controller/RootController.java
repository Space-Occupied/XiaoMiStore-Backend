package com.darkquantum.xiaomistore.user.controller;

import com.darkquantum.xiaomistore.user.model.ProductImagePath;
import com.darkquantum.xiaomistore.user.model.RecommendProduct;
import com.darkquantum.xiaomistore.user.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("")
public class RootController {
    RootService rootService;
    @Autowired
    public void setRootService(RootService rootService) {
        this.rootService = rootService;
    }

    @GetMapping("/getPhoto")
    public List<ProductImagePath> getPhoto(Long pid){
        return rootService.findProductImagePath(pid);
    }

    @GetMapping("/recommend")
    public List<RecommendProduct> getRecommend(){
        return rootService.findRecommendProduct(12);
    }
}