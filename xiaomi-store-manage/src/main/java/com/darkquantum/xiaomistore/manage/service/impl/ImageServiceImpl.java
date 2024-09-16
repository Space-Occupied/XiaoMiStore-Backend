package com.darkquantum.xiaomistore.manage.service.impl;

import com.darkquantum.xiaomistore.common.model.Image;
import com.darkquantum.xiaomistore.common.service.ImageService;
import com.darkquantum.xiaomistore.manage.dao.ImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl extends BaseServiceImpl<Image> implements ImageService {
    private ImageDao dao;
    @Autowired
    public void setImageDao(ImageDao dao) {
        this.dao = dao;
    }
}
