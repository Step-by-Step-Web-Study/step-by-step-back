package com.stby.step.service.comment;

import com.stby.step.dao.comment.CommentDAO;

import com.stby.step.dto.commentDTO.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentService {

    @Autowired
    CommentDAO commentDAO;

    public List<CommentDTO> getList(int bulletinId){
        return commentDAO.getList(bulletinId);
    }

    public void createComment(CommentDTO commentDTO){
        commentDAO.createComment(commentDTO);
    }

    public void updateComment(CommentDTO commentDTO){
         commentDAO.updateComment(commentDTO);
    }

    public void deleteComment(int commentId){
        commentDAO.deleteComment(commentId);
    }
}