package com.chinafestival.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinafestival.pojo.Admin;
import com.chinafestival.service.AdminServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
@Api(tags = "web用户")
@Controller
@RequestMapping("/AdminController")
public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    /*
    登录
    @Prama user session
    @return
     */
    @ApiOperation(value = "web用户登录", notes = "")
    @PostMapping("/login")
    @ResponseBody
    @CrossOrigin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a_id",value = "web用户账号",dataType = "int",required = true),
            @ApiImplicitParam(name = "a_name",value = "web用户名",dataType = "String",required = true),
            @ApiImplicitParam(name = "password",value = "密码",dataType = "String",required = true),

    })
    public JSON login(Admin admin, HttpSession session) {
        return adminService.login(admin, session);
    }


    /*
     *添加用户
     * @Prama user 实体类
     * @return
     */
    @ApiOperation(value = "添加用户",notes = "")
    @GetMapping("/addAdmin")
    @ResponseBody
    @CrossOrigin
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a_id",value = "web用户账号",dataType = "int",required = true),
            @ApiImplicitParam(name = "a_name",value = "web用户名",dataType = "String",required = true),
            @ApiImplicitParam(name = "password",value = "密码",dataType = "String",required = true),


    })
    public JSON addAdmin(Admin admin) {
        return adminService.addAdmin(admin);
    }

    /*
     *修改密码
     * @Prama User,pwd1,pwd2
     * @return
     */
    @GetMapping("/updateAdminPwd")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "修改密码",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a_id",value = "web用户账号",dataType = "int",required = true),
            @ApiImplicitParam(name = "password",value = "密码",dataType = "String",required = true),

    })
    public JSON updateAdminPwd(Admin admin, String pwd1, String pwd2) {
        return adminService.updateAdminPwd(admin,pwd1,pwd2);
    }

    /**
     * 删除用户
     *
     * @param a_id
     * @return
     */
    @GetMapping("/deleteAdmin")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "删除用户",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a_id",value = "web用户账号",dataType = "int",required = true),
    })
    public JSON deleteAdmin(int a_id) {
        return adminService.deleteAdmin(a_id);
    }

    //    存储用户信息
//    @Param user
//    @return
    @GetMapping("/saveAdminInfo")
    @ResponseBody
    @CrossOrigin
    public JSON saveUserInfo(Admin admin) {
        return adminService.saveAdminInfo(admin);
    }

    /*
    修改密码-----验证密码
    @Param user
    @return
     */
    @GetMapping("/verifyAdminPwd")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "修改密码-----验证密码",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a_id",value = "web用户账号",dataType = "int",required = true),
            @ApiImplicitParam(name = "a_name",value = "web用户名",dataType = "String",required = true),
            @ApiImplicitParam(name = "password",value = "密码",dataType = "String",required = true),

    })
    public JSON verifyUserPwd(Admin admin) {
        return adminService.verifyAdminPwd(admin);
    }


    /**
     * 查询所有用户
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/queryAdmin")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询所有用户", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page，limit",value = "分页查询",dataType = "int",readOnly = true),
    })
    public JSON queryAdmin(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", adminService.queryAdmin(0, 100000).size());
        json.put("data", adminService.queryAdmin(page2, limit));
        return json;
    }

    /* 查询一个作品所有信息
     * @Prama  page,limit,Keyword
     * @return
     */
    @GetMapping("/selectyAdmin")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询一个作品所有信息",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Keyword",value = "关键字(a_id,a_name,password)",dataType = "String",required = true),
    })
    public JSON selectyAdmin(@RequestParam("page")int page,@RequestParam("limit")int limit,@RequestParam("Keyword")String Keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "查询成功");
        json.put("count",  adminService.selectAdmin(0, 100000, Keyword).size());
        json.put("data",adminService.selectAdmin(page2, limit, Keyword));
        return json;
    }
}



