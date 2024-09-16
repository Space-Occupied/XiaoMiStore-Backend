package com.darkquantum.xiaomistore.manage.service.impl;

import com.darkquantum.xiaomistore.common.model.Comment;
import com.darkquantum.xiaomistore.common.service.CommentService;
import com.darkquantum.xiaomistore.manage.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment> implements CommentService {
    private CommentDao dao;
    @Autowired
    public void setCommentDao(CommentDao dao) {
        this.dao = dao;
    }
}
