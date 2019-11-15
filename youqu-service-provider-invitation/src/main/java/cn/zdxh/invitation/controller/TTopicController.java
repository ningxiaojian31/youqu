package cn.zdxh.invitation.controller;


import cn.zdxh.commons.entity.TTopic;
import cn.zdxh.commons.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 话题表 前端控制器
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
@Api(tags = "话题表")
@RestController
@RequestMapping("/tTopic")
public class TTopicController {

    @ApiOperation("保存话题")
    @PostMapping("/save")
    public Result save(@RequestBody TTopic tTopic){
        Result result = new Result();
        return result;
    }

    @ApiOperation("查询话题")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") Integer id){
        Result result = new Result();
        return result;
    }

    @ApiOperation("查询所有话题")
    @GetMapping("/gets")
    public Result getAll(){
        Result result = new Result();
        return result;
    }

    @ApiOperation("删除话题")
    @GetMapping("/del/{id}")
    public Result delete(@PathVariable("id") Integer id){
        Result result = new Result();
        return result;
    }
}

