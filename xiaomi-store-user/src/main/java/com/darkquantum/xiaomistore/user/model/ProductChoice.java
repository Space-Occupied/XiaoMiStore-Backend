package com.darkquantum.xiaomistore.user.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductChoice {
    private Long oid;
    private String option_name;
    private String choice_name;
    private BigDecimal price;
    private BigDecimal old_price;
    private Long cid;
}
