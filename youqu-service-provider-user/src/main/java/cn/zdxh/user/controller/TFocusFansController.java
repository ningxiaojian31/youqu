package cn.zdxh.user.controller;


import cn.zdxh.commons.entity.TFocusFans;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.ResultHelper;
import cn.zdxh.user.service.TFocusFansService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 关注和粉丝表 前端控制器
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
@Api(tags = "关注和粉丝控制器")
@RestController
@RequestMapping("/tFocusFans")
public class TFocusFansController {

    @Autowired
    private TFocusFansService tFocusFansService;

    @ApiOperation("关注")
    @PostMapping("/focus/add")
    public Result addFocus(@RequestBody TFocusFans tFocusFans){
        tFocusFansService.addFocus(tFocusFans);
        return ResultHelper.createSuccess("关注成功");
    }

    @ApiOperation("取消关注")
    @PostMapping("/focus/move")
    public Result moveFocus(@RequestBody TFocusFans tFocusFans){
        tFocusFansService.moveFocus(tFocusFans);
        return ResultHelper.createSuccess("取消关注成功");
    }

    @ApiOperation("是否已关注")
    @PostMapping("/focus/or")
    public Result orFocus(@RequestBody TFocusFans tFocusFans){
        return ResultHelper.createSuccess(tFocusFansService.orFocus(tFocusFans));
    }

    @ApiOperation("查询关注/粉丝")
    @GetMapping("/focusOrFans/list")
    public Result focusOrFansList(@RequestParam(name = "userId") Integer userId,
                                  @RequestParam(name = "type") Integer type){
        return ResultHelper.createSuccess(tFocusFansService.findAllFocusOrFansByUserId(type,userId));
    }

}

