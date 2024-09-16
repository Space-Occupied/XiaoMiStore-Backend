package com.darkquantum.xiaomistore.user.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductDetail {
    private String description;
    private BigDecimal min_price;
    private BigDecimal min_old_price;
    private String desc_pre;
    private String pname;
}
