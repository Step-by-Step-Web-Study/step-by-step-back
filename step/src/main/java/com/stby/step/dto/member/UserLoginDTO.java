package com.stby.step.dto.member;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserLoginDTO {

    private String email;
    private String userPw;
    private boolean enabled;
    private Date reg_date;
}
