package com.darkquantum.xiaomistore.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderInfoDetail {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long order_id;
    private String uid;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long pid;
    private Integer quantity;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long action_id;
    private String order_full_name;
    private BigDecimal price;
}
