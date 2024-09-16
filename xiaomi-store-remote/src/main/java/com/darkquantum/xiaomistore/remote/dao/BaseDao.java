package com.darkquantum.xiaomistore.remote.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
    List<T> findAll();
    T findById(Long id);
    List<T> findByCondition(T obj);
    boolean save(T obj);
    boolean saveWithUniqueId(Map<String, Object> map);
    boolean update(T obj);
    boolean deleteById(Long id);
    boolean deleteByIds(Long[] ids);
}
