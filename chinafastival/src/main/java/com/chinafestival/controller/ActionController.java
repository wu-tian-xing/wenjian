package com.chinafestival.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinafestival.pojo.Action;
import com.chinafestival.pojo.ActionUser;
import com.chinafestival.pojo.ActionView;
import com.chinafestival.service.ActionServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(tags = "活动")
@Controller
@RequestMapping("/ActionController")
public class ActionController {
    @Autowired
    private ActionServiceImpl actionService;

    /*
     *添加 活动
     * @Prama  Action实体类
     * @return
     */

    @GetMapping("/addAction")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value="添加活动", notes="")
    @ApiImplicitParams({
            @ApiImplicitParam(name="sort",value="节日类别",dataType="String",required=true),
            @ApiImplicitParam(name="title",value="标题",dataType="String",required=true),
            @ApiImplicitParam(name="starttime",value="活动开始时间",dataType="data",required=true),
            @ApiImplicitParam(name="endtime",value="活动结束时间",dataType="data",required=true),
            @ApiImplicitParam(name="needpeople",value="活动招募人数",dataType="String",required=true),
            @ApiImplicitParam(name="a_id",value="活动id",dataType="int",required=true),
            @ApiImplicitParam(name="informatin",value="活动内容",dataType="String",required=true),
            @ApiImplicitParam(name="place",value="活动地点",dataType="String",required=true),
            @ApiImplicitParam(name="way",value="活动方式",dataType="String",required=true),
            @ApiImplicitParam(name="picture",value="图片",dataType="String",required=true),

            @ApiImplicitParam(name="",value="",dataType="",required=true),

    })

    public JSON addAction(Action action){
        return actionService.addAction(action);
    }
    /*
     *删除活动
     * @Prama  a_id
     * @return
     */
    @GetMapping("/deleteAction")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "删除活动", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a_id",value = "活动id",dataType = "int",readOnly = true),

    })

    public JSON deleteAction(int a_id){
        return actionService.deleteAction(a_id);
    }
    /*
     *修改 活动deleteAction
     * @Prama  Action实体类
     * @return
     */
    @GetMapping("/updateAction")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "修改活动信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a_id",value = "活动id",dataType = "int",readOnly = true),
            @ApiImplicitParam(name="sort",value="节日类别",dataType="String",required=true),
            @ApiImplicitParam(name="title",value="标题",dataType="String",required=true),
            @ApiImplicitParam(name="starttime",value="活动开始时间",dataType="data",required=true),
            @ApiImplicitParam(name="endtime",value="活动结束时间",dataType="data",required=true),
            @ApiImplicitParam(name="needpeople",value="活动招募人数",dataType="String",required=true),
            @ApiImplicitParam(name="informatin",value="活动内容",dataType="String",required=true),
            @ApiImplicitParam(name="place",value="地点",dataType="String",required=true),
            @ApiImplicitParam(name="way",value="活动方式",dataType="String",required=true),
            @ApiImplicitParam(name="picture",value="图片",dataType="String",required=true),
    })
    public  JSON updateAction(Action action){
         return  actionService.updateAction(action);
    }





    /*
     *个人参加活动历史记录
     * @Prama  page ,limit,u_id,statecode
     * @return
     */
    @GetMapping("/selectUserAction")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "个人参加活动历史记录", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "u_id",value = "用户id",dataType = "int",readOnly = true),
            @ApiImplicitParam(name = "statecode",value = "活动状态码",dataType = "int",readOnly = true),
            @ApiImplicitParam(name = "page，limit",value = "分页查询",dataType = "int",readOnly = true),
    })
    public JSONObject selectUserAction(@RequestParam("page")int page, @RequestParam("limit") int limit, @RequestParam("u_id") int u_id,@RequestParam("statecode")int statecode){
        JSONObject json = new JSONObject();
        int page1 = page-1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", actionService.selectUserAction(0,1000,u_id,statecode).size());
        json.put("data",actionService.selectUserAction(page2, limit,u_id,statecode));
        return  json;
    }


    /*
     *查找某个活动
     * @Prama a_id
     * @return
     */
    @GetMapping("/selectOneAction")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查找某个活动所有信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a_id", value = "活动id", dataType = "int", readOnly = true),
    })
            public Action selectOneAction(int a_id){
        return actionService.selectOneAction(a_id);
    }

    /*
     *报名接口
     * @Prama  u_id,a_id
     * @return
     */
    @GetMapping("/addUser_id")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "报名接口", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a_id", value = "活动id", dataType = "int", readOnly = true),
            @ApiImplicitParam(name = "u_id",value = "用户id",dataType = "int",readOnly = true),
            })
    public JSON addUser_id(int u_id ,int a_id){
        return actionService.addUser_id(u_id, a_id);
    }


    /*
     *退出活动
     * @Prama  u_id,a_id
     * @return
     */
    @ApiOperation(value = "退出活动", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "a_id", value = "活动id", dataType = "int", readOnly = true),
            @ApiImplicitParam(name = "u_id",value = "用户id",dataType = "int",readOnly = true),
    })
    @GetMapping("/outAction")
    @ResponseBody
    @CrossOrigin
   public  JSON outAction(int a_id,int u_id){
        return actionService.outAction(a_id, u_id);
    }


    /*
     *查询所有活动
     * @Prama  page ,limit
     * @return
     */
    @GetMapping("/selectAction")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询所有活动信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page，limit",value = "分页查询",dataType = "int",readOnly = true),
    })
    public JSONObject selectAction(@RequestParam("page")int page, @RequestParam("limit")int limit){
        JSONObject json = new JSONObject();
        int page1 = page-1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", actionService.selectAction(0,1000).size());
        json.put("data",actionService.selectAction(page2, limit));
        return  json;
    }

    /* 查询一个作品所有信息
     * @Prama  page,limit,Keyword
     * @return
     */
    @GetMapping("/queryAction")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询一个作品所有信息",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Keyword",value = "关键字(sort,a_id,title,place,way)",dataType = "String",required = true),
    })
    public JSON queryAction(@RequestParam("page")int page,@RequestParam("limit")int limit,@RequestParam("Keyword")String Keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "查询成功");
        json.put("count", actionService.queryAction(0, 100000, Keyword).size());
        json.put("data",actionService.queryAction(page2, limit, Keyword));
        return json;
    }







}
