package com.stby.step.dao;

import com.stby.step.dto.commentDTO.CommentDTO;
import com.stby.step.dto.follower.FollowerDTO;
import com.stby.step.dto.member.UserInfoDTO;
import org.springframework.stereotype.Repository;

import java.security.Principal;
import java.util.List;

@Repository
public class CommentDAO {

    public static List<CommentDTO> Comment;

    public List<CommentDTO> getList(int bulletin_Id){
        return Comment;
    }
    public CommentDTO insertComment(CommentDTO commentDTO){
        Comment.add(commentDTO);
        return commentDTO;
    }

    public void updateComment(CommentDTO CommentDTO){
        Comment.stream();
    }

    public void deleteComment(int comment_Id){
        Comment.stream();
    }
}
