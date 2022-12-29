package com.stby.step.dto.bulletin;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BulletinDTO {

    private int bulletinId;
    private int writerId;
    private String content;
    private Date insertDate;

}
