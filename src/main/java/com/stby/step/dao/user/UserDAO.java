package com.stby.step.dao.user;

import com.stby.step.dto.member.UserInfoDTO;
import com.stby.step.dto.member.UserLoginDTO;
import io.swagger.models.Model;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Repository
public class UserDAO {

    public static List users;
    public static UserInfoDTO dto;

    public void createUser(UserLoginDTO userLoginDTO, UserInfoDTO userInfoDTO){
        users.add(userLoginDTO);
        users.add(userInfoDTO);

    }

    public void getLogin(HttpSession httpSession){

    }

    public UserInfoDTO readUser(int userid){
        return dto;
    }

    public void updateUser(UserInfoDTO userInfoDTO){
    }

    public void followUser(int followerId, int followingId) {

    }

    public void withdrawalUser(String userId) {
    }
}
