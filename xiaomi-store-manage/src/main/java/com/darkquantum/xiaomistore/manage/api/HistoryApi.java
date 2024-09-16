package com.darkquantum.xiaomistore.manage.api;

import com.darkquantum.xiaomistore.common.model.History;
import com.darkquantum.xiaomistore.common.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/history")
public class HistoryApi extends BaseApi<History>{
    private HistoryService service;
    @Autowired
    public void setHistoryService(HistoryService service) {
        this.service = service;
    }
}
