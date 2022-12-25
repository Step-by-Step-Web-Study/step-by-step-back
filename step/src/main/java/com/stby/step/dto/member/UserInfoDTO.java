package com.stby.step.dto.member;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UserInfoDTO {

    private int userId;
    private String userName;
    private String phoneNumber;
    private String educationalBackground;
    private String job;
    private String company;
    private String position;
    private String skills;
    private String certificate;
    private Date regdate;

}
