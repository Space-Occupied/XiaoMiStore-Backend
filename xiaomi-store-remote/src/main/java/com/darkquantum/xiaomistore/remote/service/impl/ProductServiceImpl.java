package com.darkquantum.xiaomistore.remote.service.impl;

import com.darkquantum.xiaomistore.common.model.Product;
import com.darkquantum.xiaomistore.common.service.ProductService;
import com.darkquantum.xiaomistore.remote.dao.ProductDao;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@DubboService
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
    private ProductDao dao;
    @Autowired
    public void setProductDao(ProductDao dao) {
        this.dao = dao;
    }
}
