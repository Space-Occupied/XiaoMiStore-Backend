package com.darkquantum.xiaomistore.common.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class User {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long id;
    private String username;
    private String password;
    private String nickname;
    private String avatar;
    private String sex;
    private String phone;
    private String email;
    private String address;
    private String realName;
    private LocalDateTime registrationTime;
    private LocalDateTime lastLogin;
    private Integer disabled;
}
