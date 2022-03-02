package com.chinafestival.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinafestival.mapper.FestivalMapper;
import com.chinafestival.pojo.Festival;
import com.chinafestival.pojo.FestivalAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FestivalServiceImpl implements FestivalService{
    @Autowired
    private FestivalMapper festivalMapper;

    @Override
    public JSON addFestival(Festival festival) {
        JSONObject json = new JSONObject();
        int code =0;
        code = festivalMapper.addFestival(festival);
        if (code ==1){
            json.put("msg","添加成功");
            json.put("code",1);
        }else {
            json.put("msg","添加失败");
            json.put("code",0);
        }
        return json;
    }

    @Override
    public JSON deleteFestival(int festival_id) {
        JSONObject json = new JSONObject();
        int code =0;
        code = festivalMapper.deleteFestival(festival_id);
        if (code ==1){
            json.put("msg","删除成功");
            json.put("code",1);
        }else {
            json.put("msg","删除失败");
            json.put("code",0);
        }
        return json;
    }

    @Override
    public JSON updateFestival(Festival festival) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=festivalMapper.updateFestival(festival);
            if (code==1){
                json.put("msg","修改用户信息成功");
                json.put("code",1);
            }else{
                json.put("msg","修改用户信息失败");
                json.put("code",0);
            }
        }catch (Exception e){
            e.printStackTrace();
            json.put("msg","数据接口异常,请稍后再试");
            json.put("code",-1);
        }
        return json;
    }

    @Override
    public List<Festival> queryFestival(int page, int limit) {
        return festivalMapper.queryFestival(page, limit);
    }

    @Override
    public List<Festival> selectFestival(int page, int limit, String Keyword) {
        return festivalMapper.selectFestival(page, limit, Keyword);
    }
}
