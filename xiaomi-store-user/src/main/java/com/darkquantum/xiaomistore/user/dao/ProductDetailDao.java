package com.darkquantum.xiaomistore.user.dao;

import com.darkquantum.xiaomistore.user.model.ProductChoice;
import com.darkquantum.xiaomistore.user.model.ProductDetail;
import com.darkquantum.xiaomistore.user.model.ProductImagePath;
import com.darkquantum.xiaomistore.user.model.ProductOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductDetailDao {
    List<ProductDetail> findProductDetail(Long id);
    List<ProductImagePath> findProductImagePath(Long id);
    List<ProductOption> findProductOption(Long id);
    List<ProductChoice> findProductChoice(Long id);
}
