package com.stby.step.controller.comment;

import com.stby.step.dto.commentDTO.CommentDTO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CommentController {

    @GetMapping("/getCommentList")
    @ApiOperation("댓글조회")
    @ApiImplicitParam(name="bulletinId", value="게시글 번호")
    @ResponseBody
    public String getList(int bulletinId, Model model) {
        return ""  ;
    }



    @ApiOperation(value = "댓글등록")
    @ApiImplicitParams({
            @ApiImplicitParam(name="commentId", value="댓글테이블"),
            @ApiImplicitParam(name="bulletinId", value="게시글 번호"),
            @ApiImplicitParam(name="user_id", value="작성자 ID")
    })
    @PostMapping("/writeComment")
    @ResponseBody
    public String insertComment(CommentDTO commentDTO) {
        return "";
    }

    @PutMapping("/updateComment")
    @ApiOperation("댓글수정")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bulletinId", value="게시글 번호"),
            @ApiImplicitParam(name="user_id", value="작성자 ID"),
            @ApiImplicitParam(name="com_content", value="댓글내용"),
            @ApiImplicitParam(name="com_date", value="댓글등록일"),

    })
    @ResponseBody
    public String updateComment(CommentDTO commentDTO) {
        return "";
    }

    @DeleteMapping("/deleteComment")
    @ApiOperation("댓글삭제")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "commentId", value = "댓글 테이블SEQ"),
    })
    @ResponseBody
    public String deleteComment(int commentId) {
        return "";
    }

}
