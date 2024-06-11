package com.helloWorld.helloWorld.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.helloWorld.helloWorld.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> selectUserList();

    User findByUsername(@Param("username") String username);

    int insert(@Param("user") User user);

}
