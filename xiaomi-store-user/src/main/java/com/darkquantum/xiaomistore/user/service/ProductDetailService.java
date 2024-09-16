package com.darkquantum.xiaomistore.user.service;

import com.darkquantum.xiaomistore.user.model.ProductChoice;
import com.darkquantum.xiaomistore.user.model.ProductDetail;
import com.darkquantum.xiaomistore.user.model.ProductImagePath;
import com.darkquantum.xiaomistore.user.model.ProductOption;

import java.util.List;
import java.util.Map;

public interface ProductDetailService {
    List<ProductDetail> findProductDetail(Long id);
    List<ProductImagePath> findProductImagePath(Long id);
    List<ProductOption> findProductOption(Long id);
    List<ProductChoice> findProductChoice(List<ProductOption> options);
    List<Map<String, Object>> getProductDetail(Long id);
}
