package com.darkquantum.xiaomistore.common.model.search;

import com.darkquantum.xiaomistore.common.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserSearchBean extends User {
    private LocalDate registrationDateStart;
    private LocalDate registrationDateEnd;
}
