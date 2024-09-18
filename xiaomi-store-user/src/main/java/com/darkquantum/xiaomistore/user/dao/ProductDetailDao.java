package com.darkquantum.xiaomistore.user.dao;

import com.darkquantum.xiaomistore.user.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDetailDao {
    List<ProductDetail> findProductDetail(Long id);
    List<ProductImagePath> findProductImagePath(Long id);
    List<ProductOption> findProductOption(Long id);
    List<ProductChoice> findProductChoice(Long id);
    String findCoverImage(Long id);
    List<RecommendProduct> findRecommendProduct(Integer limit);
}
