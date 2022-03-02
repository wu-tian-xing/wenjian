package com.chinafestival.service;

import com.alibaba.fastjson.JSON;
import com.chinafestival.pojo.Admin;
import com.chinafestival.pojo.FestivalAction;
import com.chinafestival.pojo.User;

import java.awt.*;
import java.util.List;

public interface UserService {
      //添加用户
    JSON addUser(User user);

    //删除用户
    JSON  deleteUser(int u_id);

    //修改用户信息
    JSON   updateUser(User user);

    //查询用户信息
    List<User> queryUser(int page, int limit);

    //模糊查询
    List<User> selectUser(int page, int limit, String Keyword);

}
