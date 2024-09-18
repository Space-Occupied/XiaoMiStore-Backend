package com.darkquantum.xiaomistore.user.service;

import com.darkquantum.xiaomistore.user.model.ProductImagePath;
import com.darkquantum.xiaomistore.user.model.RecommendProduct;

import java.util.List;

public interface RootService {
    List<ProductImagePath> findProductImagePath(Long id);
    List<RecommendProduct> findRecommendProduct(Integer limit);
}
