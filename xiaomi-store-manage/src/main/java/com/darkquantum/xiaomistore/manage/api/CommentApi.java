package com.darkquantum.xiaomistore.manage.api;

import com.darkquantum.xiaomistore.common.model.Comment;
import com.darkquantum.xiaomistore.common.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
public class CommentApi extends BaseApi<Comment>{
    private CommentService service;
    @Autowired
    public void setCommentService(CommentService service) {
        this.service = service;
    }
}
