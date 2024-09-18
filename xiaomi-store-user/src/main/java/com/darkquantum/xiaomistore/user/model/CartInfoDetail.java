package com.darkquantum.xiaomistore.user.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CartInfoDetail {
    private BigDecimal min_price;
    private String pname;
}
