package com.chinafestival.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinafestival.pojo.FestivalAction;
import com.chinafestival.service.FestivalActionService;
import com.chinafestival.service.FestivalActionServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "节日活动")
@Controller
@RequestMapping("/FestivalActionController")
public class FestivalActionController {
    @Autowired
    private FestivalActionServiceImpl festivalActionService;



    /*
     *添加 作品
     * @Prama  FestivalAction实体类
     * @return
     */
    @GetMapping("/addFestivalAction")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "添加作品",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title",value = "标题",dataType = "String",required = true),
            @ApiImplicitParam(name = "writer",value = "作者",dataType = "String",required = true),
            @ApiImplicitParam(name = "festival_id",value = "节日id",dataType = "int",required = true),
            @ApiImplicitParam(name = "actions",value = "类别",dataType = "String",required = true),
            @ApiImplicitParam(name="id",value="作品id(可以不给)",dataType="int",required=false),
            @ApiImplicitParam(name="details",value="作品内容",dataType="String",required=true),
            @ApiImplicitParam(name="pucture",value="图片",dataType="String",required=true),
            @ApiImplicitParam(name="times",value="给空就可以后端有自动获取时间",dataType="String",required=true),
    })
    public JSON addFestivalAction(FestivalAction festivalAction){
        return festivalActionService.addFestivalAction(festivalAction);
    }
    /*
     *删除 作品
     * @Prama  id
     * @return
     */
    @GetMapping("/deleteFestivalAction")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "删除 作品",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "节日作品id",dataType = "int",required = true),
    })
    public JSON deleteFestivalAction(int id){
        return festivalActionService.deleteFestivalAction(id);
    }

    /*
     *修改 作品
     * @Prama  FestivalAction实体类
     * @return
     */
    @GetMapping("/updateFestivalAction")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "修改 作品",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id",value = "节日作品id",dataType = "int",required = true),
            @ApiImplicitParam(name = "title",value = "标题",dataType = "String",required = true),
            @ApiImplicitParam(name = "writer",value = "作者",dataType = "String",required = true),
            @ApiImplicitParam(name = "festival_id",value = "节日id",dataType = "int",required = true),
            @ApiImplicitParam(name = "actions",value = "类别",dataType = "String",required = true),
            @ApiImplicitParam(name="details",value="作品内容",dataType="String",required=true),
            @ApiImplicitParam(name="pucture",value="图片",dataType="String",required=true),
    })
    public JSON updateFestivalAction(FestivalAction festivalAction){
        return festivalActionService.updateFestivalAction(festivalAction) ;
    }
    /* 查询一个作品所有信息
     * @Prama  id
     * @return
     */
    @GetMapping("/selectFestivalAction")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询一个作品所有信息",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page, limit, festival_id, actions",value = "页,范围,节日id,分类",dataType = "int,int,int,String",required = true),
    })
    public FestivalAction selectFestivalAction(int page, int limit, int festival_id, String actions){
        return festivalActionService.selectFestivalAction(page, limit, festival_id, actions);
    }


    @GetMapping("/queryFestivalAction")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询所有作品", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page，limit",value = "分页查询",dataType = "int",required = true),
    })
    public JSONObject queryFestivalAction(@RequestParam("page") int page, @RequestParam("limit") int limit){
        JSONObject json = new JSONObject();
        int page1 = page-1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", festivalActionService.queryFestivalAction(0,1000).size());
        json.put("data",festivalActionService.queryFestivalAction(page2, limit));
        return json;
    }


    /* 查询一个作品所有信息
     * @Prama  page,limit,Keyword
     * @return
             */
    @GetMapping("/selectFestivalWork")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询一个作品所有信息",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Keyword",value = "关键字",dataType = "String",required = true),
    })
    public JSON selectFestivalWork(@RequestParam("page")int page,@RequestParam("limit")int limit,@RequestParam("Keyword")String Keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "查询成功");
        json.put("count",  festivalActionService.selectFestivalWork(0, 100000, Keyword).size());
        json.put("data",festivalActionService.selectFestivalWork(page2, limit, Keyword));
        return json;
    }



}
