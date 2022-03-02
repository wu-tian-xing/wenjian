package com.chinafestival.service;

import com.alibaba.fastjson.JSON;
import com.chinafestival.pojo.Festival;
import com.chinafestival.pojo.FestivalAction;

import java.util.List;

public interface FestivalService {

    //添加节日
    JSON addFestival (Festival festival);

    //删除节日
    JSON deleteFestival ( int festival_id);

    //修改节日
    JSON  updateFestival (Festival festival);

    //查询所有节日
    List<Festival> queryFestival( int page,  int limit);

    //模糊查询
    List<Festival> selectFestival(int page, int limit, String Keyword);


}
