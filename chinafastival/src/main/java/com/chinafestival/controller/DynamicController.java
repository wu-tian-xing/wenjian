package com.chinafestival.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinafestival.pojo.DynameReview;
import com.chinafestival.pojo.Dynamic;
import com.chinafestival.pojo.DynamicView;
import com.chinafestival.service.DynamicServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags ="动态")
@Controller
@RequestMapping("/DynamicController")
public class DynamicController {
    @Autowired
    private DynamicServiceImpl dynamicService;

    /*
     *添加 动态
     * @Prama  Dynamic实体类
     * @return
     */
    @GetMapping("/addDynamic")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "添加 动态",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "details",value ="内容",dataType = "String",required = true),
            @ApiImplicitParam(name = "user_id",value = "用户id",dataType = "String",required = true),
            @ApiImplicitParam(name="d_id",value="动态id（可以不给）",dataType="int",required=true),
            @ApiImplicitParam(name="picture",value="图片",dataType="String",required=true),
            @ApiImplicitParam(name="datetime",value="给空就可以后端有自动获取时间",dataType="String",required=true),
    })
    public JSON addDynamic(Dynamic dynamic){
        return dynamicService.addDynamic(dynamic);
    }

    /*
     *删除 动态
     * @Prama  d_id
     * @return
     */
    @GetMapping("/deleteDynamic")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "删除 动态", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "d_id",value = "动态id",dataType = "int",required = true),
    })
    public JSON deleteDynamic(int d_id){
        return dynamicService.deleteDynamic(d_id);
    }

    /*
     *修改动态
     * @Prama  Dynamic实体类
     * @return
     */
    @GetMapping("/updateDynamic")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "修改动态", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "d_id",value = "动态id",dataType = "int",required = true),
            @ApiImplicitParam(name = "details",value ="内容",dataType = "String",required = true),
            @ApiImplicitParam(name = "user_id",value = "用户id",dataType = "String",required = true),
            @ApiImplicitParam(name="picture",value="图片",dataType="String",required=true),
    })
    public JSON  updateDynamic(Dynamic dynamic){
        return dynamicService.updateDynamic(dynamic);
    }

    /*
     *查询所有动态
     * @Prama  page ,limit
     * @return
     */
    @GetMapping("/qureyDynamic")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询所有动态", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page，limit",value = "分页查询",dataType = "int",readOnly = true),
    })
    public JSONObject qureyDynamic(@RequestParam("page")int page, @RequestParam("limit")int limit){
       JSONObject json = new JSONObject();
        int page1 = page-1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", dynamicService.qureyDynamic(0,1000).size());
        json.put("data",dynamicService.qureyDynamic(page2, limit));
        return  json;
    }

    /*
     *查询用户所有动态
     * @Prama  page ,limit ,u_id
     * @return
     */
    @GetMapping("/qureyUserDynamic")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询用户所有动态", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page,limit",value = "分页查询",dataType = "int",readOnly = true),

    })
    public JSONObject qureyUserDynamic(@RequestParam("page")int page, @RequestParam("limit")int limit,@RequestParam("user_id")int user_id){
        JSONObject json = new JSONObject();
        int page1 = page-1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", dynamicService.qureyUserDynamic(0,1000,user_id).size());
        json.put("data",dynamicService.qureyUserDynamic(page2, limit,user_id));
        return  json;
    }


    /*
     *修改评论数
     * @Prama  num_review ,d_id
     * @return
     */
    @GetMapping("/updateNumReview")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "修改评论数", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "d_id",value = "动态id",dataType = "int",required = true),
            @ApiImplicitParam(name="num_review",value = "评论数",dataType = "int",required = true),
    })
    public JSON updateNumReview(int num_review ,int d_id){
        return  dynamicService.updateNumReview(num_review,d_id);
    }



    /*
     *查看一个动态所有信息
     * @Prama  d_id
     * @return
     */
    @GetMapping("/selectDynameReview")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查看一个动态所有信息", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "d_id",value = "动态id",dataType = "int",required = true),
    })
    public List<DynameReview> selectDynameReview(int d_id){
        return dynamicService.selectDynameReview(d_id);
    }




    /* 查询一个作品所有信息
     * @Prama  page,limit,Keyword
     * @return
     */
    @GetMapping("/selectDynamic")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "模糊查询",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Keyword",value = "关键字(d_id,details,datetime,u_id)",dataType = "String",required = true),
    })
    public JSON selectDynamic(@RequestParam("page")int page,@RequestParam("limit")int limit,@RequestParam("Keyword")String Keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "查询成功");
        json.put("count",  dynamicService.selectDynamic(0, 100000, Keyword).size());
        json.put("data",dynamicService.selectDynamic(page2, limit, Keyword));
        return json;
    }
}




