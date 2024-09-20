package com.darkquantum.xiaomistore.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PurchaseInfo {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private List<CartItemSelection> cid_list;
    private BigDecimal order_overhead;
    private String order_client;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long user_id;
    private String phonenum;
    private String addr;
    private String order_client_realname;
}
