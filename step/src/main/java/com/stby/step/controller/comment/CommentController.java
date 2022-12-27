package com.stby.step.controller.comment;

import com.stby.step.dto.commentDTO.CommentDTO;
import com.stby.step.service.CommentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/getCommentList")
    @ApiOperation("댓글조회")
    @ApiImplicitParam(name="bulletinId", value="게시글 번호")
    public List<CommentDTO> getList(@PathVariable int bulletin_Id, Model model) {
        return commentService.getList(bulletin_Id);
    }



    @ApiOperation(value = "댓글등록")
    @ApiImplicitParams({
            @ApiImplicitParam(name="commentId", value="댓글테이블"),
            @ApiImplicitParam(name="bulletinId", value="게시글 번호"),
            @ApiImplicitParam(name="user_id", value="작성자 ID")
    })
    @PostMapping("/writeComment")
    public CommentDTO insertComment(@RequestBody CommentDTO commentDTO) {
        return commentService.insertComment(commentDTO);
    }

    @PutMapping("/updateComment")
    @ApiOperation("댓글수정")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bulletinId", value="게시글 번호"),
            @ApiImplicitParam(name="user_id", value="작성자 ID"),
            @ApiImplicitParam(name="com_content", value="댓글내용"),
            @ApiImplicitParam(name="com_date", value="댓글등록일"),

    })

    public void updateComment(@RequestBody CommentDTO commentDTO) {
         commentService.updateComment(commentDTO);
    }

    @DeleteMapping("/deleteComment")
    @ApiOperation("댓글삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commentId", value = "댓글 테이블SEQ"),
    })
    public void deleteComment(@PathVariable int comment_Id) {
         commentService.deleteComment(comment_Id);
    }

}
