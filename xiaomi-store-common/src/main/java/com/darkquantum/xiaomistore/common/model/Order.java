package com.darkquantum.xiaomistore.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Order implements Serializable {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private BigDecimal totalPrice;
    private String status;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;
    private LocalDateTime createTime;
    private Integer isDel;
    private String phoneNum;
    private String address;
    private String userRealName;
}
