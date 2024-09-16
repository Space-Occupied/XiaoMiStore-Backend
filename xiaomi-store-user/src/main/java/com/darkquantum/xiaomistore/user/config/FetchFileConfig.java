package com.darkquantum.xiaomistore.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class FetchFileConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String base = "file:///E:/XiaomiStoreFiles/";
        registry.addResourceHandler("/images/**").addResourceLocations(base + "images/");
    }
}
