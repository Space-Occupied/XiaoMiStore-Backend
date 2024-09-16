package com.darkquantum.xiaomistore.manage.api;

import com.darkquantum.xiaomistore.common.model.Product;
import com.darkquantum.xiaomistore.common.service.ProductService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductApi extends BaseApi<Product>{
    @DubboReference(id = "productService")
    private ProductService service;
}
