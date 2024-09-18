package com.darkquantum.xiaomistore.user.service.impl;

import com.darkquantum.xiaomistore.user.dao.ProductDetailDao;
import com.darkquantum.xiaomistore.user.model.ProductImagePath;
import com.darkquantum.xiaomistore.user.model.RecommendProduct;
import com.darkquantum.xiaomistore.user.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RootServiceImpl implements RootService {
    private ProductDetailDao productDetailDao;
    @Autowired
    public void setProductDetailDao(ProductDetailDao productDetailDao){
        this.productDetailDao=productDetailDao;
    }
    @Override
    public List<ProductImagePath> findProductImagePath(Long id) {
        return productDetailDao.findProductImagePath(id);
    }

    @Override
    public List<RecommendProduct> findRecommendProduct(Integer limit) {
        return productDetailDao.findRecommendProduct(limit);
    }
}
