package com.darkquantum.xiaomistore.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CartItemSelection {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long cid;
    private BigDecimal price;
}
