package com.darkquantum.xiaomistore.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String type;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long subId;
    private String url;
}
