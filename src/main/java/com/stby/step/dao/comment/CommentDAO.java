package com.stby.step.dao.comment;

import com.stby.step.dto.commentDTO.CommentDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAO {

    public static List<CommentDTO> Comment;

    public List<CommentDTO> getList(int bulletinId){
        return Comment;
    }

    public void createComment(CommentDTO commentDTO){
        Comment.add(commentDTO);
    }

    public void updateComment(CommentDTO CommentDTO){
        Comment.stream();
    }

    public void deleteComment(int commentId){
        Comment.stream();
    }
}
