package com.darkquantum.xiaomistore.remote;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class XiaomiStoreRemoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaomiStoreRemoteApplication.class, args);
    }

}
