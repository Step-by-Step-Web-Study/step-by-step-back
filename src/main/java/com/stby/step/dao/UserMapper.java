package com.stby.step.dao;

import com.stby.step.dto.member.UserInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    ArrayList<HashMap<String, Object>> findAll();

    List<UserInfoDTO> Userinfo();
}
