package com.darkquantum.xiaomistore.user.controller;

import com.alibaba.fastjson2.JSON;
import com.darkquantum.xiaomistore.user.dao.ReplaceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/testJson")
public class TestJsonController {

    ReplaceDao replaceDao;
    @Autowired
    public void setReplaceDao(ReplaceDao replaceDao) {
        this.replaceDao = replaceDao;
    }

    @GetMapping("/test")
    public ResponseEntity<Object> getJson() throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:test.json");
//        Map<String, Object> map = new HashMap<>();
//        map.put("data", JSON.parse(resource.getContentAsString(StandardCharsets.UTF_8)));
        return ResponseEntity.ok(JSON.parse(resource.getContentAsString(StandardCharsets.UTF_8)));
    }

    @RequestMapping("/modify")
    public ResponseEntity<Object> modify() throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:nav_childrens.json");
        Object res = JSON.parse(resource.getContentAsString(StandardCharsets.UTF_8));
        String resStr = res.toString();
        String[] strs = res.toString().split(",");
        for(String s : strs){
            if(s.contains("\"id\":"))
            {
                String oldId = s.split("\"id\"")[1].split("\"")[1];
                Long newId = replaceDao.findById(oldId);
                if(newId != null)
                {
                    resStr = resStr.replaceAll("\"" + oldId + "\"", newId.toString());
                }else
                {
                    resStr = resStr.replaceAll("\"" + oldId + "\"", "-1");
                }
                //System.out.println(oldId + " " + newId);
            }
        }
        return ResponseEntity.ok(JSON.parse(resStr));
    }

    @RequestMapping("/str")
    public String str() {
        return "hello world";
    }
}
