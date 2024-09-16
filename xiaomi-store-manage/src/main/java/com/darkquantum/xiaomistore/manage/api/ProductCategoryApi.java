package com.darkquantum.xiaomistore.manage.api;

import com.darkquantum.xiaomistore.common.model.ProductCategory;
import com.darkquantum.xiaomistore.common.service.ProductCategoryService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productCategory")
public class ProductCategoryApi extends BaseApi<ProductCategory>{
    @DubboReference(id = "productCategoryService")
    private ProductCategoryService service;
}
