package com.stby.step.dao;

import com.stby.step.dto.member.UserInfoDTO;
import com.stby.step.dto.member.UserLoginDTO;
import org.springframework.stereotype.Repository;

import java.security.Principal;
import java.util.List;

@Repository
public class UserDAO {

    public static List<UserLoginDTO> users;
    public static List<UserInfoDTO> userinfo;

    public List<UserLoginDTO>getcreateAccount(){
        return users;
    }

    public UserLoginDTO getInfo(UserLoginDTO userLoginDTO){
        users.add(userLoginDTO);

        return userLoginDTO;
    }

    public List<UserLoginDTO>getlogin(){
        return users;
    }

    public List<UserInfoDTO> getUserInfo(int userid){
        return userinfo;
    }


    public Principal getUpdateUser(Principal principal){
        return principal;
    }

    public void PutUser(UserInfoDTO userInfoDTO){
        userinfo.stream();
    }

}
