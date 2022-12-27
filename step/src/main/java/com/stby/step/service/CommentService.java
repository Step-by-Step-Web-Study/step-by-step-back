package com.stby.step.service;

import com.stby.step.dao.CommentDAO;

import com.stby.step.dto.commentDTO.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentService {


    @Autowired
    CommentDAO commentDAO;



    public List<CommentDTO> getList(int bulletin_Id){
        return commentDAO.getList(bulletin_Id);
    }

    public CommentDTO insertComment(CommentDTO commentDTO){
        return commentDAO.insertComment(commentDTO);
    }

    public void updateComment(CommentDTO commentDTO){
         commentDAO.updateComment(commentDTO);
    }

    public void deleteComment(int comment_Id){
        commentDAO.deleteComment(comment_Id);
    }


}