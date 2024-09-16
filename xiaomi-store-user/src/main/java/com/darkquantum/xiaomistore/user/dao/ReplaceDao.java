package com.darkquantum.xiaomistore.user.dao;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplaceDao {
    Long findById(String id);
}
