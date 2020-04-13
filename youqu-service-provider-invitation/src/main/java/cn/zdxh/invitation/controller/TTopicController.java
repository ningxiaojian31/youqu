package cn.zdxh.invitation.controller;


import cn.zdxh.commons.entity.TTopic;
import cn.zdxh.commons.utils.*;
import cn.zdxh.invitation.service.TTopicService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @SystemLog(type = SystemLogEnum.SAVE_LOG)
    @ApiOperation("保存话题")
    @PostMapping("/save")
    public Result save(@RequestBody TTopic tTopic){
        int res = tTopicService.saveEntity(tTopic);
        if (res > 0){
            return ResultHelper.createSuccess("保存话题成功");
        }
        return ResultHelper.createError("保存话题失败");
    }

    @ApiOperation("查询话题")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") Integer id){
        TTopic tTopic = tTopicService.getById(id);
        return ResultHelper.createSuccess(tTopic);
    }

    @ApiOperation("查询所有话题")
    @PostMapping("/list")
    public Result list(@RequestBody TTopic tTopic,
                         @RequestParam(value = "currentPage",required = false) Integer currentPage,
                         @RequestParam(value = "pageSize",required = false) Integer pageSize){
        //分页查询
        Page page = new Page();
        page.setCurrent(currentPage != null ? currentPage : 1);
        page.setSize(pageSize != null ? pageSize : 10);
        return ResultHelper.createSuccess(tTopicService.findAllByTopic(page,tTopic));
    }

    @SystemLog(type = SystemLogEnum.DELETE_LOG)
    @ApiOperation("删除话题")
    @DeleteMapping("/del/{id}")
    public Result delete(@PathVariable("id") Integer id){
        boolean res = tTopicService.removeById(id);
        if (res){
            return ResultHelper.createSuccess("删除话题成功");
        }
        return ResultHelper.createError("删除话题失败");
    }
}

