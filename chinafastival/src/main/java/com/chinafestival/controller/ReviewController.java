package com.chinafestival.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.chinafestival.pojo.Review;
import com.chinafestival.pojo.ReviewView;
import com.chinafestival.service.ReviewService;
import com.chinafestival.service.ReviewServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "评论")
@Controller
@RequestMapping("/ReviewController")
public class ReviewController {
    @Autowired
    private ReviewServiceImpl reviewService;


    /*
     *添加 评论
     * @Prama  Review实体类
     * @return
     */
    @GetMapping("/addReview")
    @ResponseBody
    @CrossOrigin
    @ApiImplicitParams({
            @ApiImplicitParam(name ="d_details",value = "评论内容",dataType ="String",required = true ),
            @ApiImplicitParam(name ="d_id",value = "动态id",dataType ="int",required = true ),
            @ApiImplicitParam(name ="u_id",value = "用户id",dataType ="int",required = true ),
            @ApiImplicitParam(name="r_id",value="评论id（可不写）",dataType="int",required=true),


    })
    public JSON addReview(Review review){
        return reviewService.addReview(review);
    }

    /*
     *删除 评论
     * @Prama  Review实体类
     * @return
     */
    @GetMapping("/deleteReview")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "删除评论",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="r_id",value = "评论id",dataType ="int",required = true ),
    })
    public  JSON  deleteReview(int r_id,int d_id){
        return  reviewService.deleteReview(r_id,d_id);
    }

    /*
     *修改评论
     * @Prama  Review实体类
     * @return
     */
    @GetMapping("/updateReview")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "修改评论",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name ="r_id",value = "评论id",dataType ="int",required = true ),
            @ApiImplicitParam(name ="d_details",value = "评论内容",dataType ="String",required = true ),
            @ApiImplicitParam(name ="d_id",value = "动态id",dataType ="int",required = true ),
            @ApiImplicitParam(name ="u_id",value = "用户id",dataType ="int",required = true ),

    })
    public  JSON updateReview(Review review){
        return reviewService.updateReview(review);
    }

    /*
     *查询 评论
     * @Prama  page,limit,d_id
     * @return
     */

    @GetMapping("/queryReview")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "查询所有用户", notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page，limit",value = "分页查询",dataType = "int",readOnly = true),
            })
    public JSONObject queryReview(int page, int limit){
        JSONObject json = new JSONObject();
        int page1 = page-1;
        int page2 = page1 * limit;
        json.put("code", 0);
        json.put("msg", "");
        json.put("count", reviewService.queryReview(0,0).size());
        json.put("data",reviewService.queryReview(page2, limit));
        return  json;
    }
    /* 查询一个作品所有信息
     * @Prama  page,limit,Keyword
     * @return
     */
    @GetMapping("/selectReview")
    @ResponseBody
    @CrossOrigin
    @ApiOperation(value = "模糊查询",notes = "")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Keyword",value = "关键字(u_name,d_details,r_id)",dataType = "String",required = true),
    })
    public JSON selectReview(@RequestParam("page")int page, @RequestParam("limit")int limit, @RequestParam("Keyword")String Keyword) {
        JSONObject json = new JSONObject();
        int page1 = page - 1;
        int page2 = page1 * limit;
        json.put("code", 1);
        json.put("msg", "查询成功");
        json.put("count",  reviewService.selectReview(0, 100000, Keyword).size());
        json.put("data",reviewService.selectReview(page2, limit, Keyword));
        return json;
    }





}
