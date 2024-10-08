package com.darkquantum.xiaomistore.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductOption {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long oid;
    private String option_name;
}
