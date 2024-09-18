package com.darkquantum.xiaomistore.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class CartInfo {
    private CartInfoDetail detail;
    private List<CartChoice> choices;
    private BigDecimal price;
    private Integer quantity;
    private String img_cover;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long pid;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long cart_id;
    @JsonIgnore
    private String fullname;
    @JsonIgnore
    private Long user_id;
}
