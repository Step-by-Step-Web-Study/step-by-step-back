package com.stby.step.controller.comment;

import com.stby.step.dto.commentDTO.CommentDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    @GetMapping("/getCommentList")
    @ResponseBody
    public String getList(int bulletinId, Model model) {
        return ""  ;
    }

    @PostMapping("/writeComment")
    @ResponseBody
    public String insertComment(CommentDTO commentDTO) {
        return "";
    }

    @PostMapping("/updateComment")
    @ResponseBody
    public String updateComment(CommentDTO commentDTO) {
        return "";
    }

    @PostMapping("/deleteComment")
    @ResponseBody
    public String deleteComment(int commentId) {
        return "";
    }

}
