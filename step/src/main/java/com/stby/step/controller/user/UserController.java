package com.stby.step.controller.user;

import com.stby.step.dto.member.UserInfoDTO;
import com.stby.step.dto.member.UserLoginDTO;
import com.stby.step.service.user.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @ApiOperation(value = "회원가입 요청")
    @ApiImplicitParams({
            @ApiImplicitParam(name="email", value = "이메일"),
            @ApiImplicitParam(name="userPw", value = "유저 비밀번호"),
            @ApiImplicitParam(name="enabled", value = "DEFAULT 아이디 활성화 여부 1 활성화 0 비활성화"),
            @ApiImplicitParam(name="reg_date", value = "회원 가입 일"),
            @ApiImplicitParam(name="userId", value = "DEFAULT 유저 고유 번호"),
            @ApiImplicitParam(name="userName", value = "유저 이름"),
            @ApiImplicitParam(name="phoneNumber", value = "핸드폰 번호"),
            @ApiImplicitParam(name="educationalBackground", value = "학력 사항"),
            @ApiImplicitParam(name="job", value = "직업"),
            @ApiImplicitParam(name="company", value = "회사명"),
            @ApiImplicitParam(name="position", value = "직책"),
            @ApiImplicitParam(name="skills", value = "보유 기술"),
            @ApiImplicitParam(name="certificate", value = "보유 자격증")
    })
    @PostMapping("/user")
    public void createUser(@RequestBody UserLoginDTO userLoginDTO, @RequestBody UserInfoDTO userInfoDTO) {
        userService.createUser(userLoginDTO, userInfoDTO);
    }

    @ApiOperation(value = "로그인")
    @GetMapping("/login")
    public List<UserLoginDTO> loginUser() {
        return userService.getLogin();
    }

    @ApiOperation(value = "해당 게시글의 상세 조회 화면 AND 수정 화면으로 이동", notes = "수정 화면도 동일한 요청 사용")
    @ApiImplicitParam(name = "userId", value = "유저 고유 번호")
    @GetMapping("/user/{userId}")
    public UserInfoDTO readUser(@PathVariable int userId) {
        return userService.readUser(userId);
    }

    @ApiOperation(value = "프로필 정보 수정 요청")
    @ApiImplicitParams({
            @ApiImplicitParam(name="email", value = "이메일"),
            @ApiImplicitParam(name="userId", value = "DEFAULT 유저 고유 번호"),
            @ApiImplicitParam(name="userName", value = "유저 이름"),
            @ApiImplicitParam(name="phoneNumber", value = "핸드폰 번호"),
            @ApiImplicitParam(name="educationalBackground", value = "학력 사항"),
            @ApiImplicitParam(name="job", value = "직업"),
            @ApiImplicitParam(name="company", value = "회사명"),
            @ApiImplicitParam(name="position", value = "직책"),
            @ApiImplicitParam(name="skills", value = "보유 기술"),
            @ApiImplicitParam(name="certificate", value = "보유 자격증")
    })
    @PutMapping("/user")
    public void updateUser(@RequestBody UserInfoDTO userInfoDTO) {
           userService.updateUser(userInfoDTO);
    }

    @ApiOperation(value = "이메일 중복 체크", notes = "회원가입 시 이메일 중복 여부 확인")
    @ApiImplicitParam(name="email", value = "중복 검사할 이메일")
    @PostMapping("/emailCheck")
    public boolean emailCheck(String email) {
        return false;
    }

    @ApiOperation(value = "POST 팔로우, 팔로잉 요청", notes = "userId를 팔로우, 팔로잉 각 각의 파라미터로 받아서 요청")
    @ApiImplicitParams({
            @ApiImplicitParam(name="followerId", value = "팔로워 유저 계정 고유 번호"),
            @ApiImplicitParam(name="followingId", value = "팔로잉 유저(자기 자신) 계정 고유 번호")
    })
    @PostMapping("/user/{followerId}")
    public void followUser(@PathVariable int followerId, int followingId) {
        userService.followUser(followerId, followingId);
    }

    @ApiOperation(value = "계정 탈퇴 요청 (파라미터 필요 X)")
    @DeleteMapping("/user")
    public void withdrawalUser(Principal principal) {
        userService.withdrawalUser(principal.getName());
    }
}