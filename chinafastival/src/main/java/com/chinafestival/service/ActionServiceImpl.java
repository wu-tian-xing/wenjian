package com.chinafestival.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinafestival.mapper.ActionMapper;
import com.chinafestival.pojo.Action;
import com.chinafestival.pojo.ActionUser;
import com.chinafestival.pojo.ActionView;
import com.chinafestival.pojo.FestivalAction;
import com.chinafestival.util.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ActionServiceImpl implements ActionService{
    @Autowired
    private ActionMapper actionMapper;


    @Override
    public Action selectOneAction(int a_id) {

        return actionMapper.selectOneAction(a_id);
    }

    @Override
    public JSON addAction(Action action) {
        JSONObject json = new JSONObject();
        int code =0;
        code = actionMapper.addAction(action);
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
    public JSON deleteAction(int a_id) {
        JSONObject json = new JSONObject();
        int code =0;
        code = actionMapper.deleteAction(a_id);
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
    public JSON updateAction(Action action) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=actionMapper.updateAction(action);
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
    public List<ActionView> selectAction(int page, int limit) {
        return actionMapper.selectAction(page, limit);
    }

    @Override
    public List<ActionView> selectUserAction(int page, int limit, int u_id,int statecode) {
        return actionMapper.selectUserAction(page, limit, u_id,statecode);
    }

    @Override
    public JSON addUser_id(int u_id, int a_id) {
        JSONObject json = new JSONObject();
        int code =0;
        code = actionMapper.addUser_id(a_id, u_id);
        if (code ==1){
            json.put("msg","报名成功");
            json.put("code",1);
        }else {
            json.put("msg","报名失败");
            json.put("code",0);
        }
        return json;
    }


    @Override
    public JSON outAction(int a_id, int u_id) {
        JSONObject json = new JSONObject();
        int code =0;
        code = actionMapper.outAction(a_id, u_id);
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
    public List<ActionView> queryAction(int page, int limit, String Keyword) {
        return actionMapper.queryAction(page, limit, Keyword);
    }
}
