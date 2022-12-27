package com.stby.step.dto.commentDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentDTO {

    private int comment_Id;
    private int bulletin_Id;
    private int writerId;
    private int user_id;
    private String com_content;
    private Date com_date;

}
