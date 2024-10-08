package com.darkquantum.xiaomistore.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductChoice {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long oid;
    private String option_name;
    private String choice_name;
    private BigDecimal price;
    private BigDecimal old_price;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long cid;
}
