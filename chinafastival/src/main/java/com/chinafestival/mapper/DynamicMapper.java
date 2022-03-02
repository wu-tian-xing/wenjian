package com.chinafestival.mapper;

import com.chinafestival.pojo.DynameReview;
import com.chinafestival.pojo.Dynamic;
import com.chinafestival.pojo.DynamicView;
import com.chinafestival.pojo.FestivalAction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface DynamicMapper {
    //添加动态
    int addDynamic(Dynamic dynamic);

    //删除动态
    int deleteDynamic(@Param("d_id")int d_id);

    //修改动态
    int  updateDynamic(Dynamic dynamic);

    //查询所有动态
    List<DynamicView> qureyDynamic(@Param("page")int page, @Param("limit")int limit);

    //查询个人所有动态
    List<DynamicView> qureyUserDynamic(@Param("page")int page, @Param("limit")int limit,@Param("user_id")int user_id);

    //查看一个动态所有信息
    List<DynameReview>  selectDynameReview(@Param("d_id")int d_id);

    //评论数
    int updateNumReview(@Param("num_review")int num_review,@Param("d_id")int d_id);

    //模糊查询
    List<FestivalAction> selectDynamic(@Param("page") int page, @Param("limit") int limit, @Param("Keyword")String Keyword);


}
