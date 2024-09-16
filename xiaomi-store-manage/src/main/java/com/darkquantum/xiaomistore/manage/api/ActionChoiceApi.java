package com.darkquantum.xiaomistore.manage.api;

import com.darkquantum.xiaomistore.common.model.ActionChoice;
import com.darkquantum.xiaomistore.common.service.ActionChoiceService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actionChoice")
public class ActionChoiceApi extends BaseApi<ActionChoice>{
    @DubboReference(id = "actionChoiceService")
    private ActionChoiceService service;
}
