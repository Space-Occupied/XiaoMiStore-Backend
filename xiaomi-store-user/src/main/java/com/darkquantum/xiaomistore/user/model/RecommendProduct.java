package com.darkquantum.xiaomistore.user.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class RecommendProduct {
    private Long pid;
    private String pname;
    private BigDecimal min_price;
    private String img_path;
}
