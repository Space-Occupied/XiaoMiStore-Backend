package com.darkquantum.xiaomistore.common.service;

import com.darkquantum.xiaomistore.common.utils.PaginateInfo;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {
    Map<String, Object> findAll(PaginateInfo pi);

    T findById(Long id);
    Map<String, Object> findByCondition(T obj, PaginateInfo pi);

    boolean save(T obj);

    boolean update(T obj);

    boolean deleteById(Long id);

    boolean deleteByIds(Long[] ids);
}
