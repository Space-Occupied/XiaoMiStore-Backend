package com.darkquantum.xiaomistore.manage.api;

import com.darkquantum.xiaomistore.common.model.Image;
import com.darkquantum.xiaomistore.common.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/image")
public class ImageApi extends BaseApi<Image>{
    private ImageService service;
    @Autowired
    public void setImageService(ImageService service) {
        this.service = service;
    }
}
