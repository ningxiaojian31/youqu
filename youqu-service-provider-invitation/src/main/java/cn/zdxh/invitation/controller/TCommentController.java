package cn.zdxh.invitation.controller;


import cn.zdxh.commons.entity.TComment;
import cn.zdxh.commons.utils.PageUtils;
import cn.zdxh.commons.utils.Result;
import cn.zdxh.commons.utils.ResultHelper;
import cn.zdxh.commons.utils.WebRuntimeException;
import cn.zdxh.invitation.service.TCommentService;
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
 * 评论表 前端控制器
 * </p>
 *
 * @author Justin
 * @since 2019-11-11
 */
@Api(tags = "评论表")
@RestController
@RequestMapping("/tComment")
@Slf4j
public class TCommentController {

    @Autowired
    private TCommentService tCommentService;

    @ApiOperation("保存评论")
    @PostMapping("/save")
    public Result save(@RequestBody TComment tComment){
        int res = tCommentService.saveEntity(tComment);
        if (res > 0){
            return ResultHelper.createSuccess("保存评论成功");
        }
        return ResultHelper.createError("保存评论失败");
    }

    @ApiOperation("查询评论")
    @GetMapping("/get/{id}")
    public Result get(@PathVariable("id") Integer id){
        TComment tComment = tCommentService.getById(id);
        return ResultHelper.createSuccess(tComment);
    }

    @ApiOperation("查询所有评论")
    @PostMapping("/gets")
    public Result getAll(@RequestBody TComment tComment,
                         @RequestParam(value = "currentPage",required = false) Integer currentPage,
                         @RequestParam(value = "pageSize",required = false) Integer pageSize){
        //分页查询
        com.baomidou.mybatisplus.extension.plugins.pagination.Page page = new Page();
        page.setCurrent(currentPage != null ? currentPage : 1);
        page.setSize(pageSize != null ? pageSize : 10);
        return ResultHelper.createSuccess(tCommentService.findAllByComment(page,tComment));
    }

    @ApiOperation("删除评论")
    @GetMapping("/del/{id}")
    public Result delete(@PathVariable("id") Integer id){
        boolean res = tCommentService.removeById(id);
        if (res){
            return ResultHelper.createSuccess("删除评论成功");
        }
        return ResultHelper.createError("删除评论失败");
    }
}

