package com.chinafestival.service;

import com.alibaba.fastjson.JSON;
import com.chinafestival.pojo.Action;
import com.chinafestival.pojo.ActionUser;
import com.chinafestival.pojo.ActionView;
import com.chinafestival.pojo.FestivalAction;
import org.apache.ibatis.annotations.Param;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface ActionService {
    //添加活动
    JSON addAction(Action action);

    //删除活动
    JSON deleteAction( int a_id);

    //修改活动
    JSON updateAction(Action action);

    //查询所有活动
    List<ActionView> selectAction( int page, int limit);

    //个人参加活动历史记录
    List<ActionView> selectUserAction(int page, int limit, int u_id,int statecode);

    //查找某个活动
   Action selectOneAction(int a_id);

    //报名接口
    JSON addUser_id(int u_id ,int a_id);

    //退出活动
    JSON outAction(int a_id,int u_id);

    //模糊查询
    List<ActionView> queryAction( int page, int limit, String Keyword);






}
