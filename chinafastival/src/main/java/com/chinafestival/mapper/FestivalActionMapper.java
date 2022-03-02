package com.chinafestival.mapper;


import com.chinafestival.pojo.FestivalAction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FestivalActionMapper {
    //添加作品
    int addFestivalAction(FestivalAction festivalAction);

    //删除作品
    int deleteFestivalAction(@Param("id")int id);

    //修改作品
   int updateFestivalAction(FestivalAction festivalAction);

    //查询作品
   List<FestivalAction> queryFestivalAction(@Param("page")int page,@Param("limit")int limit);

   //查询一个作品所有信息
    FestivalAction selectFestivalAction(@Param("page")int page,@Param("limit")int limit,@Param("festival_id")int festival_id,@Param("actions")String actions );

   //模糊查询
   List<FestivalAction> selectFestivalWork(@Param("page") int page, @Param("limit") int limit,@Param("Keyword")String Keyword);



}
