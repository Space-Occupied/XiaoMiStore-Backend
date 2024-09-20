package com.darkquantum.xiaomistore.user.service.impl;

import com.darkquantum.xiaomistore.user.dao.ProductDetailDao;
import com.darkquantum.xiaomistore.user.model.ProductChoice;
import com.darkquantum.xiaomistore.user.model.ProductDetail;
import com.darkquantum.xiaomistore.user.model.ProductImagePath;
import com.darkquantum.xiaomistore.user.model.ProductOption;
import com.darkquantum.xiaomistore.user.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CacheConfig(cacheNames = "com.darkquantum.xiaomistore.user.service.impl.ProductDetailServiceImpl")
@Service
public class ProductDetailServiceImpl implements ProductDetailService {
    ProductDetailDao productDetailDao;
    @Autowired
    public void setProductDetailDao(ProductDetailDao productDetailDao) {
        this.productDetailDao = productDetailDao;
    }
    public List<ProductDetail> findProductDetail(Long id) {
        return productDetailDao.findProductDetail(id);
    }

    @Override
    public List<ProductImagePath> findProductImagePath(Long id) {
        return productDetailDao.findProductImagePath(id);
    }

    @Override
    public List<ProductOption> findProductOption(Long id) {
        return productDetailDao.findProductOption(id);
    }

    @Override
    public List<ProductChoice> findProductChoice(List<ProductOption> options) {
        List<ProductChoice> res = new ArrayList<>();
        for(ProductOption option : options)
        {
            List<ProductChoice> choices = productDetailDao.findProductChoice(option.getOid());
            for(ProductChoice choice : choices)
            {
                choice.setOid(option.getOid());
                choice.setOption_name(option.getOption_name());
            }
            res.addAll(choices);
        }
        return res;
    }

    @Cacheable
    @Override
    public List<Map<String, Object>> getProductDetail(Long id) {
        List<Map<String, Object>> res = new ArrayList<>();
        res.add(Map.of("data", findProductDetail(id)));
        res.add(Map.of("data", findProductImagePath(id)));
        List<ProductOption> options = findProductOption(id);
        res.add(Map.of("data", options));
        res.add(Map.of("data", findProductChoice(options)));
        return res;
    }
}
