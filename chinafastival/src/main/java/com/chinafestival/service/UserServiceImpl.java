package com.chinafestival.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinafestival.mapper.UserMapper;
import com.chinafestival.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
     private UserMapper userMapper;
    @Override
    public JSON addUser(User user) {
        JSONObject json = new JSONObject();
        int code =0;
        code = userMapper.addUser(user);
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
    public JSON deleteUser(int u_id) {
        JSONObject json = new JSONObject();
        int code =0;
        code = userMapper.deleteUser(u_id);
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
    public JSON updateUser(User user) {
        JSONObject json = new JSONObject();
        try {
            int code=0;
            code=userMapper.updateUser(user);
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
    public List<User> queryUser(int page, int limit) {
        return userMapper.queryUser(page, limit);
    }


    @Override
    public List<User> selectUser(int page, int limit, String Keyword) {
        return userMapper.selectUser(page, limit, Keyword);
    }
}
