package com.stby.step.dao;

import com.stby.step.dto.follower.FollowerDTO;
import org.springframework.stereotype.Repository;

import java.security.Principal;
import java.util.List;

@Repository
public class FollwerDAO {

    public static List<FollowerDTO> follower;

    public FollowerDTO PostFollwUser(FollowerDTO followerDTO){
        follower.add(followerDTO);

        return followerDTO;
    }

    public Principal userWithdrawal(Principal principal){

        return principal;
    }


}
