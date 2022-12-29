package com.stby.step.service.user;

import com.stby.step.dao.user.UserDAO;
import com.stby.step.dto.member.UserInfoDTO;
import com.stby.step.dto.member.UserLoginDTO;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;


@Service
public class UserService {

    @Autowired
    UserDAO userDAO;

    public void createUser(UserLoginDTO userLoginDTO, UserInfoDTO userInfoDTO){
        userDAO.createUser(userLoginDTO, userInfoDTO);
    }

    public void getLogin(HttpSession httpSession){
         userDAO.getLogin(httpSession);
    }

    public UserInfoDTO readUser(int userid){
        return userDAO.readUser(userid);
    }

    public void updateUser(UserInfoDTO userInfoDTO){
        userDAO.updateUser(userInfoDTO);
    }

    public void followUser(int followerId, int followingId) {
        userDAO.followUser(followerId, followingId);
    }

    public void withdrawalUser(String userId) {
        userDAO.withdrawalUser(userId);
    }
}