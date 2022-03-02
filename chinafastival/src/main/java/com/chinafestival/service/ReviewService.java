package com.chinafestival.service;

import com.alibaba.fastjson.JSON;
import com.chinafestival.pojo.FestivalAction;
import com.chinafestival.pojo.Review;
import com.chinafestival.pojo.ReviewView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReviewService {
    //添加评论
    JSON addReview(Review review);

    //删除评论
    JSON  deleteReview(int r_id,int d_id);

    //修改评论
    JSON updateReview(Review review);


    //查询评论
    List<ReviewView> queryReview(int page, int limit);

    //模糊查询
    List<ReviewView> selectReview(int page, int limit, String Keyword);


}
