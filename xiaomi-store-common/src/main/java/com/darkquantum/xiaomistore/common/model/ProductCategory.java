package com.darkquantum.xiaomistore.common.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductCategory implements Serializable {
    private Integer id;
    private String name;
    private Integer pid;
    private Integer isDel;
}
