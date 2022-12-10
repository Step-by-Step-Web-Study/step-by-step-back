package com.stby.step.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Mapper
@Repository
public interface TestMapper {

    ArrayList<HashMap<String, Object>> testAll();
}
