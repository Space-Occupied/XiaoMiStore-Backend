package com.darkquantum.xiaomistore.manage.api;

import com.darkquantum.xiaomistore.common.model.User;
import com.darkquantum.xiaomistore.common.model.search.UserSearchBean;
import com.darkquantum.xiaomistore.common.service.UserService;
import com.darkquantum.xiaomistore.common.utils.PaginateInfo;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserApi extends BaseApi<User> {
    private UserService service;
    @Autowired
    public void setUserService(UserService service) {
        this.service = service;
    }

    @RequestMapping("/updateLastLogin")
    public ResponseEntity<Map<String, Object>> updateLastLogin(@RequestBody User user) {
        boolean success = service.updateLastLogin(user);
        return ResponseEntity.ok(Map.of("success", success));
    }

    @PostMapping("/changePassword")
    public ResponseEntity<Map<String, Object>> changePassword(@RequestBody User user) {
        boolean success = service.changePassword(user);
        return ResponseEntity.ok(Map.of("success", success));
    }

    @GetMapping("/findByConditionBySearchBean")
    public ResponseEntity<Map<String, Object>> findByCondition(@RequestParam(defaultValue = "1") Integer pageNo,
                                                               @RequestParam(defaultValue = "2147483647") Integer pageSize,
                                                               UserSearchBean usb) {
        List<User> objs = service.findByCondition(usb, new PaginateInfo(pageNo, pageSize));
        return getPagedResponseEntity(objs);
    }

    private ResponseEntity<Map<String, Object>> getPagedResponseEntity(List<User> objs) {
        PageInfo<User> pif = new PageInfo<>(objs);
        Map<String, Object> map = Map.of("total", pif.getTotal(),
                "pageNo", pif.getPageNum(), "pageSize", pif.getPageSize());
        return ResponseEntity.ok(Map.of("data", objs, "pi", map));
    }
}
