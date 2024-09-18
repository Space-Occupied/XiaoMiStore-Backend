package com.darkquantum.xiaomistore.user.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CartChoice {
    private String choice_name;
    private BigDecimal price;
}
