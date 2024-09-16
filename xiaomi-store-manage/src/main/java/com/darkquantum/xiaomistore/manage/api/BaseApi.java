package com.darkquantum.xiaomistore.manage.api;

import com.darkquantum.xiaomistore.common.service.BaseService;
import com.darkquantum.xiaomistore.common.utils.PaginateInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BaseApi<T> {
    private BaseService<T> getService() {
        try {
            Field f = this.getClass().getDeclaredField("service");
            f.setAccessible(true);
            return (BaseService<T>) f.get(this);
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping("/findAll")
    public ResponseEntity<Map<String, Object>> findAll(@RequestParam(defaultValue = "1") Integer pageNo,
                                                       @RequestParam(defaultValue = "2147483647") Integer pageSize) {
        PaginateInfo pi = new PaginateInfo(pageNo, pageSize);
        return ResponseEntity.ok(getService().findAll(pi));
    }

    @RequestMapping("/findById")
    public ResponseEntity<Map<String, Object>> findById(Long id) {
        Object obj = getService().findById(id);
        return ResponseEntity.ok(Map.of("data", obj));
    }

    @GetMapping("/findByCondition")
    public ResponseEntity<Map<String, Object>> findByCondition(@RequestParam(defaultValue = "1") Integer pageNo,
                                                               @RequestParam(defaultValue = "2147483647") Integer pageSize,
                                                               T obj) {
        PaginateInfo pi = new PaginateInfo(pageNo, pageSize);
        return ResponseEntity.ok(getService().findByCondition(obj, pi));
    }

    @PostMapping("/findByCondition")
    public ResponseEntity<Map<String, Object>> findByCondition(@RequestBody T obj) {
        return ResponseEntity.ok(getService().findByCondition(obj, new PaginateInfo(1, 2147483647)));
    }

    private ResponseEntity<Map<String, Object>> getPagedResponseEntity(List<T> objs) {
        PageInfo<T> pif = new PageInfo<>(objs);
        Map<String, Object> map = Map.of("total", pif.getTotal(),
                "pageNo", pif.getPageNum(), "pageSize", pif.getPageSize());
        return ResponseEntity.ok(Map.of("data", objs, "pi", map));
    }

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> save(@RequestBody T obj) {
        boolean success = getService().save(obj);
        return ResponseEntity.ok(Map.of("success", success));
    }

    @PostMapping("/update")
    public ResponseEntity<Map<String, Object>> update(@RequestBody T obj) {
        boolean success = getService().update(obj);
        return ResponseEntity.ok(Map.of("success", success));
    }

    @PostMapping("/deleteById")
    public ResponseEntity<Map<String, Object>> deleteById(Long id) {
        boolean success = getService().deleteById(id);
        return ResponseEntity.ok(Map.of("success", success));
    }

    @PostMapping("/deleteByIds")
    public ResponseEntity<Map<String, Object>> deleteByIds(@RequestBody Long[] ids) {
        System.out.println(Arrays.toString(ids));
        boolean success = getService().deleteByIds(ids);
        return ResponseEntity.ok(Map.of("success", success));
    }
}
