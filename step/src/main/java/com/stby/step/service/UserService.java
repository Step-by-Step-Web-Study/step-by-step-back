package com.stby.step.service;

import com.stby.step.dao.TestMapper;
import com.stby.step.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    TestMapper testMapper;

    public ArrayList<HashMap<String, Object>> findAll() {
        return userMapper.findAll();
    }

    public ArrayList<HashMap<String, Object>> testAll() {
        return testMapper.testAll();
    }
}