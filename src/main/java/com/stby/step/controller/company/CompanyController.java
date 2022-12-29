package com.stby.step.controller.company;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class CompanyController {

    @ApiOperation(value = "회사 공고 관심 요청")
    @ApiImplicitParams({
            @ApiImplicitParam(name="likeUserId", value = "관심 유저(자기 자신) 계정 고유 번호")
    })
    @PostMapping("/company/{likeUserId}")
    public void likeCompany(@PathVariable int likeUserId) {

    }



}
