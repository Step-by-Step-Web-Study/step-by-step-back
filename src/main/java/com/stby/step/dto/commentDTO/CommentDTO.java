package com.stby.step.dto.commentDTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CommentDTO {

    private int commentId;
    private int bulletinId;
    private int writerId;
    private String comContent;
    private Date comDate;
}
