package com.chinafestival.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinafestival.mapper.DynamicMapper;
import com.chinafestival.pojo.DynameReview;
import com.chinafestival.pojo.Dynamic;
import com.chinafestival.pojo.DynamicView;
import com.chinafestival.pojo.FestivalAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DynamicServiceImpl implements DynamicService{
    @Autowired
    private DynamicMapper dynamicMapper;

    @Override
    public JSON addDynamic(Dynamic dynamic) {
        JSONObject json = new JSONObject();
        try {
            Date time =new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String current = sdf.format(time);
            dynamic.setDatetime(current);
            int code =0;
            code =dynamicMapper.addDynamic(dynamic);
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
    public JSON deleteDynamic(int d_id) {
        JSONObject json = new JSONObject();
        int code =0;
        code =dynamicMapper.deleteDynamic(d_id);
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
    public JSON updateDynamic(Dynamic dynamic) {
        JSONObject json = new JSONObject();
        try {
            Date time =new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String current = sdf.format(time);
            dynamic.setDatetime(current);
            int code =0;
            code = dynamicMapper.updateDynamic(dynamic);
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
    public List<DynamicView> qureyDynamic(int page, int limit) {
        return dynamicMapper.qureyDynamic(page, limit);
    }

    @Override
    public List<DynamicView> qureyUserDynamic(int page, int limit, int user_id) {
        return  dynamicMapper.qureyUserDynamic(page, limit, user_id);
    }

    @Override
    public List<DynameReview> selectDynameReview(int d_id) {
        return dynamicMapper.selectDynameReview(d_id);
    }

    @Override
    public JSON updateNumReview(int num_review , int d_id) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=dynamicMapper.updateNumReview(num_review,d_id);
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
    public List<FestivalAction> selectDynamic(int page, int limit, String Keyword) {
        return dynamicMapper.selectDynamic(page, limit, Keyword);
    }
}
