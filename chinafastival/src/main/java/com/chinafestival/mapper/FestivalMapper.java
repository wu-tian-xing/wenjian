package com.chinafestival.mapper;


import com.alibaba.fastjson.JSON;
import com.chinafestival.pojo.Festival;
import com.chinafestival.pojo.FestivalAction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FestivalMapper {

    //添加节日
    int addFestival (Festival festival);

    //删除节日
    int  deleteFestival (@Param("festival_id")int festival_id);

    //修改节日
    int  updateFestival (Festival festival);

    //查询所有节日
    List<Festival> queryFestival(@Param("page")int page,@Param("limit")int limit);


    //模糊查询
    List<Festival> selectFestival(@Param("page") int page, @Param("limit") int limit, @Param("Keyword")String Keyword);


}
