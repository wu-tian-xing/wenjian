package com.chinafestival.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinafestival.pojo.Festival;
import com.chinafestival.service.FestivalServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
@Api(tags = "节日")
@Controller
@RequestMapping("/FestivalController")
public class FestivalController {
    @Autowired
    private FestivalServiceImpl festivalService;


    /*
     *添加节日
     * @Prama festival 实体类
     * @return
     */
    @GetMapping("/addFestival")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "添加节日",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "festival_id",value = "节日id",dataType = "int",required = true),
            @ApiImplicitParam(name = "festival_name",value = "节日名称",dataType = "String",required = true),
    })
    public JSON addFestival (Festival festival){
        return festivalService.addFestival(festival);
    }

    //删除节日
    /*
     * @Prama festival_id
     * @return
     */
    @GetMapping("/deleteFestival")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "删除节日",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "festival_id",value = "节日id",dataType = "int",required = true),
    })
    public JSON deleteFestival (int festival_id){
        return festivalService.deleteFestival(festival_id);
    }

    //修改节日
    /*
     * @Prama festival实体类
     * @return
     */
    @GetMapping("/updateFestival")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "修改节日",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "festival_id",value = "节日id",dataType = "int",required = true),
            @ApiImplicitParam(name = "festival_name",value = "节日名称",dataType = "String",required = true),

    })
    public JSON  updateFestival (Festival festival){
        return festivalService.updateFestival(festival);
    }



    /**
     * 查询所有节日
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/queryFestival")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询所有节日", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page，limit",value = "分页查询",dataType = "int",readOnly = true),
    })
    public JSON queryFestival(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", festivalService.queryFestival(0,1000).size());
        json.put("data",festivalService.queryFestival(page2,limit));
        return json;
    }
    /* 查询一个作品所有信息
     * @Prama  page,limit,Keyword
     * @return
     */
    @GetMapping("/selectFestival")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询一个作品所有信息",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Keyword",value = "关键字(a_id,title,place,endtime,starttime)",dataType = "String",required = true),
    })
    public JSON selectFestival(@RequestParam("page")int page,@RequestParam("limit")int limit,@RequestParam("Keyword")String Keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "查询成功");
        json.put("count",  festivalService.selectFestival(0, 100000, Keyword).size());
        json.put("data",festivalService.selectFestival(page2, limit, Keyword));
        return json;
    }


}
