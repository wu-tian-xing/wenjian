package com.chinafestival.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinafestival.mapper.AdminMapper;
import com.chinafestival.pojo.Admin;
import com.chinafestival.pojo.FestivalAction;
import com.chinafestival.util.UntilTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> queryAdmin(int page, int limit) {

        return adminMapper.queryAdminInfo(page, limit);
    }

    //登录
    @Override
    public JSON login(Admin admin, HttpSession session) {
        JSONObject json = new JSONObject();
        //  admin.setPassword(UntilTools.Encrypted_MD5(admin.getPassword()));
        Admin login = adminMapper.login(admin);
        if (login != null){
            login.setPassword("");
            json.put("msg","登录成功");
            json.put("data",login);
            json.put("code",1);
            session.setAttribute("login_session",login);
        }else {
            json.put("msg","登录失败");
            json.put("data",null);
            json.put("code",0);
        }
        return json;
    }

    @Override
    public JSON saveAdminInfo(Admin admin) {
        JSONObject json = new JSONObject();
        int code =0;
        code = adminMapper.saveAdminInfo(admin);
        if (code ==1){
            json.put("code",1);
            json.put("msg","保存成功");
        }else {
            json.put("code",0);
            json.put("msg","保存失败");
        }
        return json;
    }

    @Override
    public JSON verifyAdminPwd(Admin admin) {
        JSONObject json = new JSONObject();
        admin.setPassword(UntilTools.Encrypted_MD5(admin.getPassword()));
        if (adminMapper.verifyAdminPwd(admin)!=null){
            json.put("msg","验证成功");
            json.put("code",1);
            System.out.println(json);
        }else {
            json.put("msg","验证失败");
            json.put("code",0);
        }
        return json;
    }

    @Override
    public JSON updateAdminPwd(Admin admin, String pwd1, String pwd2) {
        JSONObject json = new JSONObject();
        int code=0;
        if (!pwd1.isEmpty()){
            if (!pwd2.isEmpty()){
                if (pwd1.equals(pwd2)){
                    if (!admin.getPassword().equals(pwd1)){
                        admin.setPassword(UntilTools.Encrypted_MD5(pwd1));
                        code = adminMapper.updateAdminPwd(admin);
                        if (code ==1){
                            json.put("msg","修改成功");
                            json.put("code",1);
                        }else {
                            json.put("msg","修改失败");
                            json.put("code",0);
                        }
                    }else {
                        json.put("msg","新密码与旧密码相同");
                        json.put("code",0);
                    }
                }else {
                    json.put("msg","两次密码不一样");
                    json.put("code",0);
                }
            }else {
                json.put("msg","再输入一次密码");
                json.put("code",0);
            }
        }else {
            json.put("msg","请输入新密码");
            json.put("code",0);
        }
        return json;
    }

    @Override
    public JSON addAdmin(Admin admin) {
        JSONObject json = new JSONObject();
        int code =0;
        code = adminMapper.addAdmin(admin);
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
    public JSON deleteAdmin(int a_id) {
        JSONObject json = new JSONObject();
        int code =0;
        code = adminMapper.deleteAdmin(a_id);
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
    public List<FestivalAction> selectAdmin(int page, int limit, String Keyword) {
        return adminMapper.selectAdmin(page, limit, Keyword);
    }
}
