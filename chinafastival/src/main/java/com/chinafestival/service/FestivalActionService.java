package com.chinafestival.service;

import com.alibaba.fastjson.JSON;
import com.chinafestival.pojo.FestivalAction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FestivalActionService {
    //添加作品
    JSON addFestivalAction(FestivalAction festivalAction);

    //删除作品
    JSON deleteFestivalAction(int id);

    //修改作品
    JSON updateFestivalAction(FestivalAction festivalAction);

    //查询一个作品所有信息
    FestivalAction selectFestivalAction( int page, int limit, int festival_id, String actions);


    //查询作品
    List<FestivalAction> queryFestivalAction(int page,int limit);


    //模糊查询
    List<FestivalAction> selectFestivalWork(int page, int limit,String Keyword);






}
