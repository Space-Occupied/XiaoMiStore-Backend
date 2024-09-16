package com.darkquantum.xiaomistore.remote.bean;

import com.darkquantum.xiaomistore.common.utils.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SnowFlakeBean {
    @Bean
    public SnowFlake getSnowFlake() {
        return new SnowFlake(1);
    }
}
