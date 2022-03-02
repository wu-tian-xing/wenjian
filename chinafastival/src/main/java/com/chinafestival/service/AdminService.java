package com.chinafestival.service;

import com.alibaba.fastjson.JSON;
import com.chinafestival.pojo.Admin;
import com.chinafestival.pojo.FestivalAction;
import com.chinafestival.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface AdminService {
    //登录
    JSON  login(Admin admin, HttpSession session);

    //存储个人信息
    JSON saveAdminInfo(Admin admin);

    //修改密码验证
    JSON verifyAdminPwd(Admin admin);

    //修改密码
    JSON updateAdminPwd(Admin admin, String pwd1, String pwd2);

    //修改密码/重复输入
    // JSON updateUserPwd(User user, String pwd1, String pwd2);

    //添加用户
    JSON  addAdmin(Admin admin);

    //删除用户
    JSON deleteAdmin(int a_id);

    //查看用户
    List<Admin> queryAdmin(int page, int limit);

    //模糊查询
    List<FestivalAction> selectAdmin(int page, int limit, String Keyword);

}
