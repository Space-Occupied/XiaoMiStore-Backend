package com.darkquantum.xiaomistore.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Choice {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal oldPrice;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long optionId;
}
