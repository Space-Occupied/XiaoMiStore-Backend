package com.darkquantum.xiaomistore.manage.controller;

import com.darkquantum.xiaomistore.common.model.Image;
import com.darkquantum.xiaomistore.common.service.ImageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/picture")
public class PictureController {
    @Value("${file.base-path}")
    private String base;

    private ImageService service;
    @Autowired
    public void setImageService(ImageService service) {
        this.service = service;
    }

    @RequestMapping("/avatar")
    public ResponseEntity<Map<String, Object>> avatar(HttpServletRequest request, MultipartFile file) throws IOException {
        System.out.println(request.getHeader("Authorization"));
        System.out.println(base);
        try {
            Thread.sleep(1);
        } catch (Exception ignored) {}
        //检查路径是否存在，不存在则创建
        File dir = new File(base + "pics/avatars");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if(file.getOriginalFilename() == null || file.getOriginalFilename().isEmpty() || file.getOriginalFilename().lastIndexOf(".") == -1) {
            return ResponseEntity.ok(Map.of("success", false));
        }
        String timestamp = String.valueOf(System.currentTimeMillis());
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        if(!ext.equals(".jpg") && !ext.equals(".png") && !ext.equals(".jpeg") && !ext.equals(".gif") && !ext.equals(".bmp") && !ext.equals(".webp") && !ext.equals(".svg") && !ext.equals(".ico")) {
            return ResponseEntity.ok(Map.of("success", false));
        }
        String fileName = timestamp + ext;
        file.transferTo(new File(base + "images/users/" + fileName));
        return ResponseEntity.ok(Map.of("success", true, "url", "/api/images/users/" + fileName));
    }

    @RequestMapping("/list/{type}/{subId}")
    public synchronized ResponseEntity<Map<String, Object>> pictureList(HttpServletRequest request, MultipartFile file,
                                                                        @PathVariable String type, @PathVariable Long subId) throws IOException {
//        System.out.println(typeId + " " + subId);
        try {
            Thread.sleep(1);
        } catch (Exception ignored) {}
        if(file.getOriginalFilename() == null || file.getOriginalFilename().isEmpty() || file.getOriginalFilename().lastIndexOf(".") == -1) {
            return ResponseEntity.ok(Map.of("success", false));
        }
        String timestamp = String.valueOf(System.currentTimeMillis());
        String ext = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        if(!ext.equals(".jpg") && !ext.equals(".png") && !ext.equals(".jpeg") && !ext.equals(".gif") && !ext.equals(".bmp") && !ext.equals(".webp") && !ext.equals(".svg") && !ext.equals(".ico")) {
            return ResponseEntity.ok(Map.of("success", false));
        }
        String fullName = base + "pics/list/" + type + "/" + subId + "/" + timestamp + ext;
        file.transferTo(new File(fullName));
        service.save(new Image(0L, type, subId, "/api/picList/" + type + "/" + subId + "/" + timestamp + ext));
        return ResponseEntity.ok(Map.of("success", true));
    }

    @RequestMapping("/listStart/{typeId}/{subId}")
    public ResponseEntity<Map<String, Object>> pictureListStart(HttpServletRequest request, @PathVariable Integer typeId, @PathVariable Integer subId) {
//        if (!service.deleteByTS(typeId, subId))
//        {
//            return ResponseEntity.ok(Map.of("success", false));
//        }
        File dir = new File(base + "pics/list/" + typeId + "/" + subId + "/");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return ResponseEntity.ok(Map.of("success", true));
    }

    @RequestMapping("/listEnd/{typeId}/{subId}")
    public ResponseEntity<Map<String, Object>> pictureListEnd(HttpServletRequest request, @PathVariable Integer typeId, @PathVariable Integer subId) {
        return ResponseEntity.ok(Map.of("success", true));
    }
}
