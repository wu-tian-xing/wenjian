package com.chinafestival.mapper;

import com.chinafestival.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository

public interface UserMapper
{

    //添加用户
    int  addUser(User user);

    //删除用户
    int deleteUser(@Param("u_id") int u_id);

    //修改用户信息
    int updateUser(User user);

    //查询用户
    List<User> queryUser(@Param("page") int page, @Param("limit") int limit);

    //模糊查询
    List<User> selectUser(@Param("page") int page, @Param("limit") int limit, @Param("Keyword")String Keyword);




}
