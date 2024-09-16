package com.darkquantum.xiaomistore.manage.api;

import com.darkquantum.xiaomistore.common.model.Choice;
import com.darkquantum.xiaomistore.common.service.ChoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/choice")
public class ChoiceApi extends BaseApi<Choice>{
    private ChoiceService service;
    @Autowired
    public void setChoiceService(ChoiceService service) {
        this.service = service;
    }
}
