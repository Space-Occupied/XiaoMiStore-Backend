package com.darkquantum.xiaomistore.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class OrderInfo {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long order_id;
    private LocalDateTime order_time;
    private BigDecimal order_overhead;
    private String order_client;
    private String phonenum;
    private String addr;
    private String order_client_realname;
    @JsonIgnore
    private Long uid;
}
