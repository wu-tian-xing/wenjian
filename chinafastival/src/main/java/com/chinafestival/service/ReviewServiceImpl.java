package com.chinafestival.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinafestival.mapper.ReviewMapper;
import com.chinafestival.pojo.Review;
import com.chinafestival.pojo.ReviewView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService{
    @Autowired
    private ReviewMapper reviewMapper;



    @Override
    public JSON addReview(Review review) {
        JSONObject json = new JSONObject();
        try {
            Date time =new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String current = sdf.format(time);
            review.setDateime(current);
            int code =0;
            code = reviewMapper.addReview(review);
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
        return json;    }



    @Override
    public JSON deleteReview(int r_id,int d_id) {
        JSONObject json = new JSONObject();
        int code =0;
        code = reviewMapper.deleteReview(r_id,d_id);
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
    public JSON updateReview(Review review) {
        JSONObject json = new JSONObject();
        try {
            Date time =new Date(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String current = sdf.format(time);
            review.setDateime(current);
            int code =0;
            code = reviewMapper.updateReview(review);
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
    public List<ReviewView> queryReview(int page, int limit) {
        return reviewMapper.queryReview(page, limit);
    }

    @Override
    public List<ReviewView> selectReview(int page, int limit, String Keyword){
        return reviewMapper.selectReview(page, limit, Keyword);
    }
}

