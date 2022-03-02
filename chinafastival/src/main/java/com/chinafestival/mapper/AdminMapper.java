package com.chinafestival.mapper;

import com.chinafestival.pojo.Admin;
import com.chinafestival.pojo.FestivalAction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdminMapper {
    //登录
    Admin login(Admin admin);

    //存储个人信息
    int saveAdminInfo(Admin admin);

    //修改密码-----验证密码
    Admin verifyAdminPwd(Admin admin);

    //修改密码-----输入新密码-----重复输入新密码
    int updateAdminPwd(Admin admin);

    //添加用户
    int addAdmin(Admin admin);

    //删除用户
    int deleteAdmin(@Param("a_id") int a_id);


    //查看用户
    List<Admin> queryAdminInfo(@Param("page") int page, @Param("limit") int limit);

    //模糊查询
    List<FestivalAction> selectAdmin(@Param("page") int page, @Param("limit") int limit, @Param("Keyword")String Keyword);








}
