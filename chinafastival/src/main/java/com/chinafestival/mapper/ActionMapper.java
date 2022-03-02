package com.chinafestival.mapper;


import com.chinafestival.pojo.Action;
import com.chinafestival.pojo.ActionView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ActionMapper {

    //添加活动
    int addAction(Action action);

    //删除活动
    int deleteAction(@Param("a_id")int a_id);

    //修改活动
    int updateAction(Action action);

    //查询所有活动
    List<ActionView> selectAction(@Param("page")int page, @Param("limit")int limit);

    //个人参加活动历史记录
    List<ActionView> selectUserAction(@Param("page")int page,@Param("limit")int limit,@Param("u_id")int u_id,@Param("statecode")int statecode);


    //查找某个活动
    Action selectOneAction(@Param("a_id")int a_id);

    //报名接口
    int addUser_id(@Param("u_id")int u_id ,@Param("a_id")int a_id);


    //退出活动
    int outAction(@Param("a_id")int a_id,@Param("u_id")int u_id);

    //模糊查询
    List<ActionView> queryAction(@Param("page")int page,@Param("limit")int limit,@Param("Keyword") String Keyword);





}
