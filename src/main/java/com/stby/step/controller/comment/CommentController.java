package com.stby.step.controller.comment;

import com.stby.step.dto.commentDTO.CommentDTO;
import com.stby.step.service.comment.CommentService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/comment/{bulletinId}")
    @ApiOperation(value = "댓글 조회", notes = "수정 화면도 동일한 요청 사용")
    @ApiImplicitParam(name="bulletinId", value="조회 할 댓글 리스트의 게시글 번호", paramType = "path", dataType = "int", required = true)
    public List<CommentDTO> getList(@PathVariable int bulletinId) {
        return commentService.getList(bulletinId);
    }

    @ApiOperation(value = "댓글 등록")
    @ApiImplicitParams({
        @ApiImplicitParam(name="comContent", value="댓글 내용"),
        @ApiImplicitParam(name="commentId", value="DEFAULT 댓글 고유 번호"),
        @ApiImplicitParam(name="bulletinId", value="DEFAULT 게시글 고유 번호"),
        @ApiImplicitParam(name="writerId", value="DEFAULT 작성자 고유 번호"),
        @ApiImplicitParam(name="comDate", value="DEFAULT 댓글 등록 일")
    })
    @PostMapping("/comment")
    public void createComment(@RequestBody CommentDTO commentDTO) {
        commentService.createComment(commentDTO);
    }

    @PutMapping("/comment/{commentId}")
    @ApiOperation("댓글 수정")
    @ApiImplicitParams({
        @ApiImplicitParam(name="comContent", value="댓글 내용", paramType = "path", dataType = "String", required = true),
        @ApiImplicitParam(name="commentId", value="수정할 댓글 고유 번호", paramType = "path", dataType = "int", required = true),
        @ApiImplicitParam(name="bulletinId", value="DEFAULT 게시글 고유 번호", paramType = "path", dataType = "int"),
        @ApiImplicitParam(name="writerId", value="DEFAULT 작성자 고유 번호", paramType = "path", dataType = "int"),
        @ApiImplicitParam(name="comDate", value="DEFAULT 댓글 등록 일", paramType = "path", dataType = "date")
    })
    public void updateComment(@RequestBody CommentDTO commentDTO, @PathVariable int commentId) {
         commentService.updateComment(commentDTO);
    }

    @DeleteMapping("/comment/{commentId}")
    @ApiOperation("댓글 삭제")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "commentId", value = "삭제할 댓글 고유 번호", paramType = "path", dataType = "int", required = true)
    })
    public void deleteComment(@PathVariable int commentId) {
         commentService.deleteComment(commentId);
    }
}
