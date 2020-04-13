package cn.zdxh.other.log.controller;


import cn.zdxh.commons.entity.SysLog;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.ResultHelper;
import cn.zdxh.other.log.service.SysLogService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 系统日志表 前端控制器
 * </p>
 *
 * @author Justin
 * @since 2020-04-10
 */
@Api(tags = "日志管理控制器")
@RestController
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @ApiOperation("查询所有日志")
    @PostMapping("/list")
    public Result list(@RequestBody SysLog sysLog,
                       @RequestParam(value = "currentPage",required = false) Integer currentPage,
                       @RequestParam(value = "pageSize",required = false) Integer pageSize){
        //分页查询
        Page page = new Page();
        page.setCurrent(currentPage != null ? currentPage : 1);
        page.setSize(pageSize != null ? pageSize : 10);
        return ResultHelper.createSuccess(sysLogService.findAllBySysLog(page,sysLog));
    }

    @ApiOperation("删除日志")
    @DeleteMapping("/del/{id}")
    public Result delete(@PathVariable("id") Integer id){
        boolean res = sysLogService.removeById(id);
        if (res){
            return ResultHelper.createSuccess("删除日志成功");
        }
        return ResultHelper.createError("删除日志失败");
    }

}

