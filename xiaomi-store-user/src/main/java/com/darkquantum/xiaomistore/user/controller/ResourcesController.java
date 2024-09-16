package com.darkquantum.xiaomistore.user.controller;

import com.alibaba.fastjson2.JSON;
import com.darkquantum.xiaomistore.user.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resources")
public class ResourcesController {

    private ProductDetailService productDetailService;
    @Autowired
    public void setProductDetailService(ProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    @GetMapping("/slide")
    public Object getSlide(){
        return parseJsonFile("slide.json");
    }

    @GetMapping("/nav")
    public Object getNav(){
        return parseJsonFile("nav_childrens.json");
    }

    @GetMapping("/product")
    public Object getProduct(){
        return parseJsonFile("product.json");
    }

    @GetMapping("/category")
    public Object getCategory(){
        return parseJsonFile("category.json");
    }

    @GetMapping("/detail")
    public List<Map<String, Object>> getDetail(Long pid){
        return productDetailService.getProductDetail(pid);
    }

    private Object parseJsonFile(String fileName) {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:" + fileName);
        Object res = null;
        try {
            res = JSON.parse(resource.getContentAsString(StandardCharsets.UTF_8));
        }catch (Exception ignored) {}
        return res;
    }
}
