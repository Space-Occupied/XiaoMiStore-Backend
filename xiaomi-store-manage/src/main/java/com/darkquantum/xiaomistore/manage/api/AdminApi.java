package com.darkquantum.xiaomistore.manage.api;

import com.darkquantum.xiaomistore.common.model.Admin;
import com.darkquantum.xiaomistore.common.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminApi extends BaseApi<Admin>{
    private AdminService service;
    @Autowired
    public void setAdminService(AdminService service) {
        this.service = service;
    }
}
