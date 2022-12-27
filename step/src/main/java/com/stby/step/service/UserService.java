package com.stby.step.service;

import com.stby.step.dao.UserDAO;
import com.stby.step.dto.member.UserInfoDTO;
import com.stby.step.dto.member.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;


@Service
public class UserService {


    @Autowired
    UserDAO userDAO;


    public List<UserLoginDTO> getcreateAccount(){
        return userDAO.getcreateAccount();
    }

    public UserLoginDTO getInfo(UserLoginDTO userLoginDTO){
        return userDAO.getInfo(userLoginDTO);
    }

    public List<UserLoginDTO> getlogin(){
        return userDAO.getlogin();
    }


    public List<UserInfoDTO> getUserInfo(int userid){
        return userDAO.getUserInfo(userid);
    }

    public Principal getUpdateUser(Principal principal){
        return userDAO.getUpdateUser(principal);
    }

    public void PutUser(UserInfoDTO userInfoDTO){
        userDAO.PutUser(userInfoDTO);
    }

}