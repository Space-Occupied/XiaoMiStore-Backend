package com.darkquantum.xiaomistore.manage.dao;

import org.apache.ibatis.annotations.Param;

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
