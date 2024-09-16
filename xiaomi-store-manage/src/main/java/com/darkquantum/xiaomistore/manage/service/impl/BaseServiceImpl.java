package com.darkquantum.xiaomistore.manage.service.impl;

import com.darkquantum.xiaomistore.common.utils.SnowFlake;
import com.darkquantum.xiaomistore.manage.dao.BaseDao;
import com.darkquantum.xiaomistore.common.service.BaseService;
import com.darkquantum.xiaomistore.common.utils.PaginateInfo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseServiceImpl<T> implements BaseService<T> {
    private SnowFlake snowFlake;

    @Autowired
    public void setSnowFlake(SnowFlake snowFlake) {
        this.snowFlake = snowFlake;
    }

    private BaseDao getDao() {
        try {
            Field f = this.getClass().getDeclaredField("dao");
            f.setAccessible(true);
            return (BaseDao) f.get(this);
        } catch (Exception e) {
            return null;
        }
    }

    public Map<String, Object> findAll(PaginateInfo pi) {
        try (Page<?> ignored = PageHelper.startPage(pi.getPageNo(), pi.getPageSize())) {
            List<T> list = getDao().findAll();
            return getStringObjectMap(pi, list);
        }
    }

    public T findById(Long id) {
        return (T) getDao().findById(id);
    }
    public Map<String, Object> findByCondition(T obj, PaginateInfo pi) {
        try (Page<?> ignored = PageHelper.startPage(pi.getPageNo(), pi.getPageSize())) {
            List<T> list = getDao().findByCondition(obj);
            return getStringObjectMap(pi, list);
        }
    }

    private Map<String, Object> getStringObjectMap(PaginateInfo pi, List<T> list) {
        PageInfo<T> pageInfo = new PageInfo<>(list);

        pi.setPageNo(pageInfo.getPageNum());
        pi.setPageSize(pageInfo.getPageSize());
        pi.setTotal((int) pageInfo.getTotal());

        list = List.copyOf(list);

        return Map.of("data", list, "pi", pi);
    }

    public boolean save(T obj) {
        // 改用雪花算法生成id
        // 读取T中所有键值对，生成一个Map对象，并将生成的ID整合进其中
        Map<String, Object> map = new HashMap<>();
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                map.put(f.getName(), f.get(obj));
            } catch (IllegalAccessException ignored) {}
        }
        map.put("id", snowFlake.nextId());
        return getDao().saveWithUniqueId(map);
//        return getDao().save(obj);
    }

    public boolean update(T obj) {
        return getDao().update(obj);
    }

    public boolean deleteById(Long id) {
        return getDao().deleteById(id);
    }

    public boolean deleteByIds(Long[] ids) {
        return getDao().deleteByIds(ids);
    }
}
