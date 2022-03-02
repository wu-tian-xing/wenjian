package com.chinafestival.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinafestival.pojo.User;
import com.chinafestival.service.UserService;
import com.chinafestival.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = "小程序用户")
@Controller
@RequestMapping("/UserController")

public class UserController {
   @Autowired
   private  UserServiceImpl userService;
    /*
     *添加用户
     * @Prama user 实体类
     * @return
     */
   @GetMapping("/addUser")
   @ResponseBody
   @CrossOrigin
   @ApiOperation(value ="添加用户",notes = "")
   @ApiImplicitParams({
           @ApiImplicitParam(name ="u_id",value = "用户id",dataType = "int",required = true),
           @ApiImplicitParam(name ="u_name",value = "昵称",dataType = "String",required = true),
           @ApiImplicitParam(name ="password",value = "密码",dataType = "String",required = true),

   })
   public JSON addUser(User user) {
       return userService.addUser(user);
   }


   //删除用户
    /*
     * @Prama u_id
     * @return
    */
   @GetMapping("/deleteUser")
   @ResponseBody
   @CrossOrigin
   @ApiOperation(value ="删除用户",notes = "")
   @ApiImplicitParams({
           @ApiImplicitParam(name ="u_id",value = "用户id",dataType = "int",required = true),

           @ApiImplicitParam(name ="",value = "",dataType = "",required = true),

   })
    public  JSON  deleteUser(int u_id){
        return userService.deleteUser(u_id);
    }


    //修改用户信息
    /*
     * @Prama user实体类
     * @return
     */
    @GetMapping("/updateUser")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value ="修改用户信息",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="u_id",value = "用户id",dataType = "int",required = true),

    })
    public JSON   updateUser(User user){
        return userService.updateUser(user);
    }

    /**
     * 查看用户
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/queryUser")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询所有用户", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page，limit",value = "分页查询",dataType = "int",readOnly = true),
    })
    public JSON queryUser(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", userService.queryUser(0,1000).size());
        json.put("data",userService.queryUser(page2,limit));
        return json;
    }
    /* 查询一个作品所有信息
     * @Prama  page,limit,Keyword
     * @return
     */
    @GetMapping("/selectUser")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询一个作品所有信息",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Keyword",value = "关键字(u_id,u_name)",dataType = "String",required = true),
    })
    public JSON selectUser(@RequestParam("page")int page,@RequestParam("limit")int limit,@RequestParam("Keyword")String Keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "查询成功");
        json.put("count", userService.selectUser(0, 100000, Keyword).size());
        json.put("data",userService.selectUser(page2, limit, Keyword));
        return json;
    }


}
