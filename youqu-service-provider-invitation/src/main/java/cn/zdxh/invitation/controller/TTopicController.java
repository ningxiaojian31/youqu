package cn.zdxh.invitation.controller;


import cn.zdxh.commons.entity.Page;
import cn.zdxh.commons.entity.TTopic;
import cn.zdxh.commons.utils.PageUtils;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.WebRuntimeException;
import cn.zdxh.invitation.service.TTopicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
@Slf4j
public class TTopicController {

    @Autowired
    private TTopicService tTopicService;

    @ApiOperation("保存话题")
    @PostMapping("/save")
    public Result save(@RequestBody TTopic tTopic){
        Result result = new Result();
        try {
            boolean res = false;
            if (tTopic.getId() != null){
                //修改
                res = tTopicService.updateById(tTopic);
            }else {
                res = tTopicService.save(tTopic);
            }

            if (res){
                result.success("保存话题成功");
                return result;
            }
        }catch (Exception e){
            log.error(e.getMessage());
            throw new WebRuntimeException("保存话题失败");
        }
        return result;
    }

    @ApiOperation("查询话题")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") Integer id){
        Result result = new Result();
        TTopic tTopic = tTopicService.getById(id);
        result.success(tTopic);
        return result;
    }

    @ApiOperation("查询所有话题")
    @PostMapping("/gets")
    public Result getAll(@RequestBody TTopic tTopic,
                         @RequestParam(value = "currentPage",required = false) Integer currentPage,
                         @RequestParam(value = "pageSize",required = false) Integer pageSize
    ){
        //封装操作
        Result result = new Result();
        Map<String,Object> map = new HashMap<>();
        Page page = new Page(currentPage,pageSize);
        map.put("tTopic",tTopic);
        map.put("page",PageUtils.initStart(page));
        //查询操作
        List<TTopic> tTopicList = tTopicService.findAllByTopic(map);
        result.success(tTopicList);
        return result;
    }

    @ApiOperation("删除话题")
    @GetMapping("/del/{id}")
    public Result delete(@PathVariable("id") Integer id){
        Result result = new Result();
        try {
            boolean res = tTopicService.removeById(id);
            if (res){
                result.success("删除话题成功");
                return result;
            }
        }catch (Exception e){
            log.error(e.getMessage());
            throw new WebRuntimeException("删除话题失败");
        }
        return result;
    }
}

