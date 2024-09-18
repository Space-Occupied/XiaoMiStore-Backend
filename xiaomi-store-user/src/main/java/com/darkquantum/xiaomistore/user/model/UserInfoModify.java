package com.darkquantum.xiaomistore.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoModify {
    private String id;
    private String uid;
    private String uname;
    private String default_addr;
    private String default_phone;
    private String realname;
    private String gender;
    private String avatar_path;
}
