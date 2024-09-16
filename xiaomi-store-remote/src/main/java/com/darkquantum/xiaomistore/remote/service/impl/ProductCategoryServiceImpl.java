package com.darkquantum.xiaomistore.remote.service.impl;

import com.darkquantum.xiaomistore.common.model.ProductCategory;
import com.darkquantum.xiaomistore.common.service.ProductCategoryService;
import com.darkquantum.xiaomistore.remote.dao.ProductCategoryDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DubboService
@Service
public class ProductCategoryServiceImpl extends BaseServiceImpl<ProductCategory> implements ProductCategoryService {
    private ProductCategoryDao dao;
    @Autowired
    public void setProductCategoryDao(ProductCategoryDao dao) {
        this.dao = dao;
    }
}
