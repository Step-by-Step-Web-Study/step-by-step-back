package com.stby.step.controller.bulletin;

import com.stby.step.dto.bulletin.BulletinDTO;
import com.stby.step.service.BulletinService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/bulletin")
@Slf4j
public class BulletinController {

    @Autowired
    BulletinService bulletinService;

    @ApiOperation(value = "게시글 조회 화면으로 이동")
    @GetMapping("/list")
    public List<BulletinDTO> getList(@RequestBody BulletinDTO bulletinDTO, Model model) {
        return bulletinService.getList(bulletinDTO,model);
    }

    @ApiOperation(value = "해당 게시글의 상세 조회 화면으로 이동")
    @ApiImplicitParam(name="bulletinId", value = "게시글 번호")
    @GetMapping("/read/{bulletinId}")
    public List<BulletinDTO> readBulletin(@PathVariable int bulletinId, Model model) {
        return bulletinService.readBulletin(bulletinId,model);
    }

    @ApiOperation(value = "게시글 작성 화면 이동 비동기 통신")
    @GetMapping("/write")
    @ResponseBody
    public List<BulletinDTO> insertBulletin() {
        return bulletinService.insertBulletin();
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
    public BulletinDTO insertwriteBulletin(@RequestBody BulletinDTO bulletinDTO, Principal principal) {
        return bulletinService.insertwriteBulletin(bulletinDTO,principal);
    }

    @ApiOperation(value = "게시글 수정 화면으로 이동 비동기 통신")
    @ApiImplicitParam(name="bulletinId", value="게시글 번호")
    @GetMapping("/update/{bulletinId}")
    @ResponseBody
    public List<BulletinDTO> updateBulletin(@PathVariable int bulletinId, Model model) {
        return bulletinService.updateBulletin(bulletinId,model);
    }

    @ApiOperation(value = "게시글 수정 요청")
    @ApiImplicitParams({
            @ApiImplicitParam(name="bulletinId", value="게시글 번호"),
            @ApiImplicitParam(name="content", value="게시글 내용"),
            @ApiImplicitParam(name="writerId", value="DEFAULT 작성자"),
            @ApiImplicitParam(name="insertDate", value="DEFAULT 게시글 작성일"),
            @ApiImplicitParam(name="principal", value="DEFAULT 게시글 작성자")
    })
    @PutMapping("/update")
    @ResponseBody
    public void Bulletin(@RequestBody BulletinDTO bulletinDTO) {
         bulletinService.Bulletin(bulletinDTO);
    }

    @ApiOperation(value = "게시글 삭제 요청")
    @ApiImplicitParam(name="bulletinId", value="게시글 번호")
    @DeleteMapping("/delete")
    public void deleteBulletin(int bulletinId) {
         bulletinService.deleteBulletin(bulletinId);
    }
}