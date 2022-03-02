package com.chinafestival.service;

import com.alibaba.fastjson.JSON;
import com.chinafestival.pojo.DynameReview;
import com.chinafestival.pojo.Dynamic;
import com.chinafestival.pojo.DynamicView;
import com.chinafestival.pojo.FestivalAction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicService {
    //添加动态
    JSON addDynamic(Dynamic dynamic);

    //删除动态
    JSON deleteDynamic(int d_id);

    //修改动态
    JSON  updateDynamic(Dynamic dynamic);

    //查询所有动态
    List<DynamicView> qureyDynamic(int page, int limit);

    //查询个人所有动态
    List<DynamicView> qureyUserDynamic(int page, int limit ,int user_id);

    //查看一个动态所有信息
    List<DynameReview> selectDynameReview(int d_id);

    //评论数
    JSON updateNumReview(int num_review, int d_id);

    //模糊查询
    List<FestivalAction> selectDynamic(int page, int limit, String Keyword);


}
