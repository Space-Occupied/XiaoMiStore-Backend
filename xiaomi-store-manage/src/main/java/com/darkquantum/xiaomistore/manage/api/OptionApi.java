package com.darkquantum.xiaomistore.manage.api;

import com.darkquantum.xiaomistore.common.model.Option;
import com.darkquantum.xiaomistore.common.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/option")
public class OptionApi extends BaseApi<Option>{
    private OptionService service;
    @Autowired
    public void setOptionService(OptionService service) {
        this.service = service;
    }
}
