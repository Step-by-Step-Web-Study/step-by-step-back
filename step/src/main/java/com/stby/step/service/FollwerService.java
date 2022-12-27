package com.stby.step.service;

import com.stby.step.dao.FollwerDAO;
import com.stby.step.dto.follower.FollowerDTO;
import com.stby.step.dto.member.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;


@Service
public class FollwerService {


    @Autowired
    FollwerDAO follwerDAO;



    public FollowerDTO PostFollwUser(FollowerDTO followerDTO){
        return follwerDAO.PostFollwUser(followerDTO);
    }

    public Principal userWithdrawal(Principal principal){
        return follwerDAO.userWithdrawal(principal);
    }


}