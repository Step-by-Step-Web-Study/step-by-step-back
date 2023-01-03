package com.stby.step.controller.bulletin;

import com.stby.step.dto.bulletin.BulletinDTO;
import com.stby.step.service.bulletin.BulletinService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class BulletinController {

    @Autowired
    BulletinService bulletinService;

    @ApiOperation(value = "게시글 조회 화면")
    @GetMapping("/bulletin/list")
    public List<BulletinDTO> getList(@RequestBody BulletinDTO bulletinDTO) {
        return bulletinService.getList(bulletinDTO);
    }

    @ApiOperation(value = "게시글 작성 요청")
    @ApiImplicitParams({
        @ApiImplicitParam(name="content", value="게시글 내용", paramType = "query", dataType = "String", required = true),
        @ApiImplicitParam(name="bulletinId", value="DEFAULT 게시글 고유 번호", paramType = "query", dataType = "String"),
        @ApiImplicitParam(name="writerId", value="DEFAULT 게시글 작성자 고유 번호", paramType = "query", dataType = "String"),
        @ApiImplicitParam(name="insertDate", value="DEFAULT 게시글 작성일", paramType = "query", dataType = "String"),
        @ApiImplicitParam(name="principal", value="DEFAULT 게시글 작성자", paramType = "query", dataType = "String")
    })
    @PostMapping("/bulletin")
    public void createBulletin(@RequestBody BulletinDTO bulletinDTO, Principal principal) {
        bulletinService.createBulletin(bulletinDTO,principal.getName());
    }

    @ApiOperation(value = "해당 게시글의 상세 조회 화면 AND 수정 화면", notes = "수정 화면도 동일한 요청 사용")
    @ApiImplicitParam(name="bulletinId", value = "게시글 고유 번호", paramType = "path", dataType = "int", required = true)
    @GetMapping("/bulletin/{bulletinId}")
    public BulletinDTO readBulletin(@PathVariable int bulletinId) {
        return bulletinService.readBulletin(bulletinId);
    }

    @ApiOperation(value = "게시글 수정 요청")
    @ApiImplicitParams({
        @ApiImplicitParam(name="bulletinId", value="게시글 고유 번호", paramType = "query", dataType = "int", required = true),
        @ApiImplicitParam(name="content", value="게시글 내용", paramType = "query", dataType = "String", required = true),
        @ApiImplicitParam(name="writerId", value="게시글 작성자 고유 번호", paramType = "query", dataType = "int", required = true),
        @ApiImplicitParam(name="insertDate", value="게시글 작성일", paramType = "query", dataType = "Date", required = true),
    })
    @PutMapping("/bulletin")
    @ResponseBody
    public void updateBulletin(@RequestBody BulletinDTO bulletinDTO) {
         bulletinService.updateBulletin(bulletinDTO);
    }

    @ApiOperation(value = "게시글 삭제 요청")
    @ApiImplicitParam(name="bulletinId", value="게시글 고유 번호", paramType = "path", dataType = "int", required = true)
    @DeleteMapping("/bulletin/{bulletinId}")
    public void deleteBulletin(@PathVariable int bulletinId) {
         bulletinService.deleteBulletin(bulletinId);
    }
}