package com.chinafestival.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinafestival.mapper.FestivalActionMapper;
import com.chinafestival.pojo.FestivalAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service

public class FestivalActionServiceImpl implements FestivalActionService{
    @Autowired
    private FestivalActionMapper festivalActionMapper;

    @Override
    public FestivalAction selectFestivalAction(int page, int limit, int festival_id, String actions) {
        return festivalActionMapper.selectFestivalAction(page, limit, festival_id, actions);
    }

    @Override
    public List<FestivalAction> selectFestivalWork(int page, int limit, String Keyword) {
        return festivalActionMapper.selectFestivalWork(page, limit, Keyword);
    }

    @Override
    public JSON addFestivalAction(FestivalAction festivalAction) {
        JSONObject json = new JSONObject();
        try {
            Date time =new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String current = sdf.format(time);
            festivalAction.setTimes(current);
            int code =0;
            code =festivalActionMapper.addFestivalAction(festivalAction);
            if (code ==1){
                json.put("msg","添加成功");
                json.put("code",1);
            }else {
                json.put("msg","添加失败");
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
    public JSON deleteFestivalAction(int id) {
        JSONObject json = new JSONObject();
        int code =0;
        code =festivalActionMapper.deleteFestivalAction(id);
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
    public JSON updateFestivalAction(FestivalAction festivalAction) {
        JSONObject json = new JSONObject();
        try {
            Date time =new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String current = sdf.format(time);
           festivalAction.setTimes (current);
            int code =0;
            code = festivalActionMapper.updateFestivalAction(festivalAction);
            if (code ==1){
                json.put("msg","修改成功");
                json.put("code",1);
            }else {
                json.put("msg","修改失败");
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
    public List<FestivalAction> queryFestivalAction(int page, int limit) {
        return festivalActionMapper.queryFestivalAction(page, limit);
    }


}
