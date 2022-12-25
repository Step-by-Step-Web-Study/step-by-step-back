package com.stby.step.controller.bulletin;

import com.stby.step.dto.bulletin.BulletinDTO;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bulletin")
@Slf4j
public class BulletinController {

    @ApiOperation(value = "게시글 조회 화면으로 이동")
    @GetMapping("/list")
    public String getList(Model model) {
        return "";
    }

    @ApiOperation(value = "해당 게시글의 상세 조회 화면으로 이동")
    @ApiImplicitParam(name="bulletinId", value = "게시글 번호")
    @GetMapping("/read/{bulletinId}")
    public String readBulletin(@PathVariable int bulletinId, Model model) {
        return "";
    }

    @ApiOperation(value = "게시글 작성 화면으로 이동")
    @GetMapping("/write")
    public String insertBulletin() {
        return "";
    }

    @ApiOperation(value = "게시글 작성 요청")
    @ApiImplicitParams({
            @ApiImplicitParam(name="content", value="게시글 내용"),
            @ApiImplicitParam(name="bulletinId", value="DEFAULT 게시글 번호"),
            @ApiImplicitParam(name="writerId", value="DEFAULT 게시글 작성자"),
            @ApiImplicitParam(name="insertDate", value="DEFAULT 게시글 작성일"),
            @ApiImplicitParam(name="principal", value="DEFAULT 게시글 작성자")
    })
    @PostMapping("/writeBulletin")
    public String insertBulletin(BulletinDTO bulletinDTO, Principal principal) {
        return "";
    }

    @ApiOperation(value = "게시글 수정 화면으로 이동")
    @ApiImplicitParam(name="bulletinId", value="게시글 번호")
    @GetMapping("/update/{bulletinId}")
    public String updateBulletin(@PathVariable int bulletinId, Model model) {
        return "";
    }

    @ApiOperation(value = "게시글 수정 요청")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bulletinId", value="게시글 번호"),
            @ApiImplicitParam(name="content", value="게시글 내용"),
            @ApiImplicitParam(name="writerId", value="DEFAULT 작성자"),
            @ApiImplicitParam(name="insertDate", value="DEFAULT 게시글 작성일"),
            @ApiImplicitParam(name="principal", value="DEFAULT 게시글 작성자")
    })
    @PostMapping("/update")
    public String updateBulletin(BulletinDTO bulletinDTO) {
        return "";
    }

    @ApiOperation(value = "게시글 삭제 요청")
    @ApiImplicitParam(name="bulletinId", value="게시글 번호")
    @PostMapping("/delete")
    public String deleteBulletin(int bulletinId) {
        return "";
    }
}