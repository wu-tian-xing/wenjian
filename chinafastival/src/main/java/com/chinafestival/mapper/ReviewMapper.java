package com.chinafestival.mapper;


import com.chinafestival.pojo.FestivalAction;
import com.chinafestival.pojo.Review;
import com.chinafestival.pojo.ReviewView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReviewMapper {

    //添加评论
   int addReview(Review review);

    //删除评论
    int  deleteReview(@Param("r_id")int r_id,@Param("d_id")int d_id);

    //修改评论
    int  updateReview(Review review);

    //修改点赞数
    int updatepraise(@Param("r_id")int r_id,@Param("d_id")int d_id,@Param("praise")int praise);

    //查询评论
    List<ReviewView> queryReview(@Param("page")int page,@Param("limit")int limit);

    //模糊查询
    List<ReviewView> selectReview(@Param("page") int page, @Param("limit") int limit, @Param("Keyword")String Keyword);


}
