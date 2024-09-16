package com.darkquantum.xiaomistore.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Comment {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;
    private String type;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subId;
    private Integer rate;
    private String comment;
    private LocalDateTime commentTime;
    private Integer isDel;
}
