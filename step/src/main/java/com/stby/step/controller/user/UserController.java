package com.stby.step.controller.user;

import com.stby.step.dto.follower.FollowerDTO;
import com.stby.step.dto.member.UserInfoDTO;
import com.stby.step.dto.member.UserLoginDTO;
import com.stby.step.service.FollwerService;
import com.stby.step.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    FollwerService follwerService;

    @ApiOperation(value = "회원가입 화면으로 이동")
    @GetMapping("/createAccount")
    public List<UserLoginDTO> createAccount() {
        return userService.getcreateAccount();
    }

    @ApiOperation(value = "회원가입 요청")
    @ApiImplicitParams({
            @ApiImplicitParam(name="email", value = "이메일"),
            @ApiImplicitParam(name="userPw", value = "유저 비밀번호"),
            @ApiImplicitParam(name="enabled", value = "DEFAULT 아이디 활성화 여부 1 활성화 0 비활성화"),
            @ApiImplicitParam(name="reg_date", value = "회원 가입 일"),
            @ApiImplicitParam(name="userId", value = "DEFAULT 유저 SEQ 값"),
            @ApiImplicitParam(name="userName", value = "유저 이름"),
            @ApiImplicitParam(name="phoneNumber", value = "핸드폰 번호"),
            @ApiImplicitParam(name="educationalBackground", value = "학력 사항"),
            @ApiImplicitParam(name="job", value = "직업"),
            @ApiImplicitParam(name="company", value = "회사명"),
            @ApiImplicitParam(name="position", value = "직책"),
            @ApiImplicitParam(name="skills", value = "보유 기술"),
            @ApiImplicitParam(name="certificate", value = "보유 자격증")
    })
    @PostMapping("/createAccount")
    public UserLoginDTO createAccount(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.getInfo(userLoginDTO);
    }

    @ApiOperation(value = "로그인 화면으로 이동")
    @GetMapping("/login")
    public List<UserLoginDTO> loginUser() {
        return userService.getlogin();
    }

    @ApiOperation(value = "userId의 프로필 화면으로 이동")
    @ApiImplicitParam(name = "userId", value = "조회하려는 계정의 고유 ID 값")
    @GetMapping("/readUser/{userId}")
    public List<UserInfoDTO> readUser(@PathVariable int userId, Model model)
    {
        return userService.getUserInfo(userId);
    }

    @ApiOperation(value = "프로필 수정 화면으로 이동 (파라미터 필요 X)")
    @GetMapping("/updateUser")
    public Principal updateUser(Principal principal, Model model) {
        return userService.getUpdateUser(principal);
    }

    @ApiOperation(value = "프로필 정보 수정 요청")
    @ApiImplicitParams({
            @ApiImplicitParam(name="email", value = "이메일"),
            @ApiImplicitParam(name="userId", value = "DEFAULT 유저 SEQ 값"),
            @ApiImplicitParam(name="userName", value = "유저 이름"),
            @ApiImplicitParam(name="phoneNumber", value = "핸드폰 번호"),
            @ApiImplicitParam(name="educationalBackground", value = "학력 사항"),
            @ApiImplicitParam(name="job", value = "직업"),
            @ApiImplicitParam(name="company", value = "회사명"),
            @ApiImplicitParam(name="position", value = "직책"),
            @ApiImplicitParam(name="skills", value = "보유 기술"),
            @ApiImplicitParam(name="certificate", value = "보유 자격증")
    })
    @PutMapping("/updateUser")
    public void updateUser(@RequestBody UserInfoDTO userInfoDTO, Model model) {
           userService.PutUser(userInfoDTO);
    }

    @ApiOperation(value = "이메일 중복 체크", notes = "비동기 통신으로 이메일 중복 여부 확인")
    @ApiImplicitParam(name="email", value = "중복 검사할 이메일")
    @ResponseBody
    @PostMapping("/emailCheck")
    public boolean emailCheck(String email) {

        return false;
    }

    @ApiOperation(value = "POST 팔로우, 팔로잉 요청", notes = "userId를 팔로우, 팔로잉 각 각의 파라미터로 받아서 요청")
    @ApiImplicitParams({
            @ApiImplicitParam(name="followerID", value = "팔로워유저 userId"),
            @ApiImplicitParam(name="followingID", value = "팔로잉유저 userId")
    })
    @PostMapping("/followUser")
    public FollowerDTO followUser(@RequestBody FollowerDTO followerDTO) {
        return follwerService.PostFollwUser(followerDTO);
    }

    @ApiOperation(value = "계정 탈퇴 요청 (파라미터 필요 X)")
    @PostMapping("/withdrawal")
    public Principal userWithdrawal(Principal principal) {
        return follwerService.userWithdrawal(principal);
    }

}